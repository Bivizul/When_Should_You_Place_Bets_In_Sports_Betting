package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.spliska

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.bivizul.thebeginnersguidetobettingonformula1.util.*
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.LoadingContent
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.main.MainScreen
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Spliska
import com.bivizul.whenshouldyouplacebetsinsportsbetting.repository.SpliskaRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SpliskaScreen() : Screen,KoinComponent {

    @Composable
    override fun Content() {
        val repository = SpliskaRepository()
//        val repository : SpliskaRepository by inject()

        val context = LocalContext.current
        val activity = LocalContext.current as Activity
        val navigator = LocalNavigator.currentOrThrow
        val prefspliska = activity.getSharedPreferences("prefspliska", Context.MODE_PRIVATE)
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

        //     image in activity
//        LaunchedEffect(activity) {
//            activity.window .setBackgroundDrawable(BitmapDrawable)
//        }

        LaunchedEffect(Unit) {
            Log.e("qwer", "LaunchedEffect")
            repository.getResspliska(Spliska(
                getSpliskamm(),
                getSpliskasim(context),
                getSpliskaid(prefspliska),
                getSpliskal(),
                getSpliskat()
            ))

        }

        val resspliska by repository.resspliska.collectAsState(initial = null)

        Log.e("qwer", "resspliska : ${resspliska?.resspliska}")
        LoadingContent()
        resspliska?.resspliska?.let {
            if (it == "no") {
                    navigator.push(MainScreen())
            } else if (it == "nopush") {
//                OneSignal.disablePush(true)
                    navigator.push(MainScreen())
//            } else if (it.length > 2) {
//                // TODO()
//                    navigator.push(MainScreen())
            } else {
                navigator.push(MainScreen())
//                LoadingContent()
            }
        }

        /*LaunchedEffect(Unit) {
            resspliska?.resspliska?.let {
                if (it == "no") {
                    Log.e("qwer", "resspliska - no")
                    delay(1000)
                    navigator.push(MainScreen())
                } else if (it == "nopush") {

                    Log.e("qwer", "resspliska - nopush")
//                OneSignal.disablePush(true)
                    delay(1000)
                    navigator.push(MainScreen())
                } else {
                    Log.e("qwer", "resspliska - else")
                    // TODO()
                    delay(1000)
                    navigator.push(MainScreen())
                }
            }
        }
        LoadingContent()*/
    }
}

//class FeedListScreen : Screen, KoinComponent {
//    @Composable
//    override fun Content() {
//        val store: FeedStore by inject()
//        FeedList(store = store)
//    }
//}