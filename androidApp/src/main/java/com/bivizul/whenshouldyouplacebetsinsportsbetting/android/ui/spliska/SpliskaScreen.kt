package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.spliska

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.bivizul.thebeginnersguidetobettingonformula1.util.*
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.LoadingContent
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.main.MainScreen
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Resspliska
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Spliska
import com.bivizul.whenshouldyouplacebetsinsportsbetting.repository.SpliskaRepository
import kotlinx.coroutines.delay
import org.koin.core.component.KoinComponent

class SpliskaScreen() : Screen, KoinComponent {

    @Composable
    override fun Content() {
//        val sdk : ConticSDK by inject()
        val repository = SpliskaRepository()

        val context = LocalContext.current
        val activity = LocalContext.current as Activity
        val navigator = LocalNavigator.currentOrThrow

        val prefspliska = activity.getSharedPreferences("prefspliska",Context.MODE_PRIVATE)
//        val emptyContics = Contics("", emptyList())


        /*val screenModel = rememberScreenModel { ConticModel(repository) }
        val state by screenModel.state.collectAsState()
//        LaunchedEffect(currentCompositeKeyHash) {
//            screenModel.getItem()
//        }
        LaunchedEffect(Unit) {
            screenModel.getItem()
        }
        Log.e("qwer","state : $state")
        when(val result = state){
            is ConticModel.State.Loading -> { LoadingContent() }
            is ConticModel.State.Result -> {
                MainContent(screenModel, result.contics, navigator::pop)}
        }*/

        LaunchedEffect(Unit) {
            repository.getResspliska(Spliska(
                getSpliskamm(),
                getSpliskasim(context),
                getSpliskaid(prefspliska),
                getSpliskal(),
                getSpliskat()
            ))


        }

        val resspliska by repository.resspliska.collectAsState(initial = Resspliska(""))

        LaunchedEffect(Unit){
            Log.e("qwer","resspliska : $resspliska")
            if(resspliska.resspliska == "no"){
                delay(1000)
                navigator.push(MainScreen())
            } else if(resspliska.resspliska == "nopush"){
//                OneSignal.disablePush(true)
                delay(1000)
                navigator.push(MainScreen())
            } else {

                // TODO()
                delay(1000)
                navigator.push(MainScreen())
            }
        }

        LoadingContent()


    }
}

//class FeedListScreen : Screen, KoinComponent {
//    @Composable
//    override fun Content() {
//        val store: FeedStore by inject()
//        FeedList(store = store)
//    }
//}