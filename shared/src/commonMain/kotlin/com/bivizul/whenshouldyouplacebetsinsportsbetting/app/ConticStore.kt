package com.bivizul.whenshouldyouplacebetsinsportsbetting.app

import com.bivizul.whenshouldyouplacebetsinsportsbetting.ConticReader
import com.bivizul.whenshouldyouplacebetsinsportsbetting.RssReader
import com.bivizul.whenshouldyouplacebetsinsportsbetting.core.entity.ConticItem
import com.bivizul.whenshouldyouplacebetsinsportsbetting.core.entity.Contics
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class ConticState(
    val progress: Boolean,
    val feeds: List<Contics>,
    val selectedConticItem: Contics? = null //null means selected all
) : State

fun ConticState.mainConticPosts() = (selectedConticItem?.conticItem ?: feeds.flatMap { it.conticItem }).sortedByDescending { it.id }

sealed class ConticAction : Action {
    data class Refresh(val forceLoad: Boolean) : ConticAction()
    data class Add(val url: String) : ConticAction()
    data class Delete(val url: String) : ConticAction()
    data class SelectContic(val feed: ConticItem?) : ConticAction()
    data class Data(val feeds: List<ConticItem>) : ConticAction()
    data class Error(val error: Exception) : ConticAction()
}

sealed class ConticSideEffect : Effect {
    data class Error(val error: Exception) : ConticSideEffect()
}

class ConticStore(
//    private val rssReader: RssReader
    private val conticReader: ConticReader
) : Store<ConticState, ConticAction, ConticSideEffect>,
    CoroutineScope by CoroutineScope(Dispatchers.Main) {

    private val state = MutableStateFlow(ConticState(false, emptyList()))
    private val sideEffect = MutableSharedFlow<ConticSideEffect>()

    override fun observeState(): StateFlow<ConticState> = state

    override fun observeSideEffect(): Flow<ConticSideEffect> = sideEffect

    override fun dispatch(action: ConticAction) {
        Napier.d(tag = "ConticStore", message = "Action: $action")
        val oldState = state.value

        val newState = when (action) {
            is ConticAction.Refresh -> {
                if (oldState.progress) {
                    launch { sideEffect.emit(ConticSideEffect.Error(Exception("In progress"))) }
                    oldState
                } else {
                    launch { loadAllContics(action.forceLoad) }
                    oldState.copy(progress = true)
                }
            }
            is ConticAction.Add -> {
                if (oldState.progress) {
                    launch { sideEffect.emit(ConticSideEffect.Error(Exception("In progress"))) }
                    oldState
                } else {
                    launch { addContic(action.url) }
                    ConticState(true, oldState.feeds)
                }
            }
            is ConticAction.Delete -> {
                if (oldState.progress) {
                    launch { sideEffect.emit(ConticSideEffect.Error(Exception("In progress"))) }
                    oldState
                } else {
                    launch { deleteContic(action.url) }
                    ConticState(true, oldState.feeds)
                }
            }
            is ConticAction.SelectContic -> {
                if (action.feed == null || oldState.feeds.contains(action.feed)) {
                    oldState.copy(selectedConticItem = action.feed)
                } else {
                    launch { sideEffect.emit(ConticSideEffect.Error(Exception("Unknown feed"))) }
                    oldState
                }
            }
            is ConticAction.Data -> {
                if (oldState.progress) {
                    val selected = oldState.selectedConticItem?.let {
                        if (action.feeds.contains(it)) it else null
                    }
                    ConticState(false, action.feeds, selected)
                } else {
                    launch { sideEffect.emit(ConticSideEffect.Error(Exception("Unexpected action"))) }
                    oldState
                }
            }
            is ConticAction.Error -> {
                if (oldState.progress) {
                    launch { sideEffect.emit(ConticSideEffect.Error(action.error)) }
                    ConticState(false, oldState.feeds)
                } else {
                    launch { sideEffect.emit(ConticSideEffect.Error(Exception("Unexpected action"))) }
                    oldState
                }
            }
        }

        if (newState != oldState) {
            Napier.d(tag = "ConticStore", message = "NewState: $newState")
            state.value = newState
        }
    }

    private suspend fun loadAllContics(forceLoad: Boolean) {
        try {
            val allContics = conticReader.getAllContics(forceLoad)
            dispatch(ConticAction.Data(allContics))
        } catch (e: Exception) {
            dispatch(ConticAction.Error(e))
        }
    }

    private suspend fun addContic(url: String) {
        try {
            conticReader.addContic(url)
            val allContics = conticReader.getAllContics(false)
            dispatch(ConticAction.Data(allContics))
        } catch (e: Exception) {
            dispatch(ConticAction.Error(e))
        }
    }

    private suspend fun deleteContic(url: String) {
        try {
            conticReader.deleteContic(url)
            val allContics = conticReader.getAllContics(false)
            dispatch(ConticAction.Data(allContics))
        } catch (e: Exception) {
            dispatch(ConticAction.Error(e))
        }
    }
}
