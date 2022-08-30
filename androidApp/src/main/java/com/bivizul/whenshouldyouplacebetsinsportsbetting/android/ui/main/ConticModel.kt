package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.main

import android.util.Log
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Contics
import com.bivizul.whenshouldyouplacebetsinsportsbetting.repository.ConticRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch

class ConticModel(val conticRepository: ConticRepository):
    StateScreenModel<ConticModel.State>(State.Loading) {

    sealed class State {
        object Loading : State()
        data class Result(val contics: Contics) : State()
    }

    fun getItem() {
        coroutineScope.launch(Dispatchers.IO) {
            conticRepository.getContics()
            Log.e("qwer", "getItem")
            mutableState.value = State.Result(conticRepository.contics.single())
        }
    }


}