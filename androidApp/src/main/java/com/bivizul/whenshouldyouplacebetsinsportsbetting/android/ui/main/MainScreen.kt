package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.main

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.LoadingContent
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.NextScreen
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Contics
import com.bivizul.whenshouldyouplacebetsinsportsbetting.repository.ConticRepository
import org.koin.core.component.KoinComponent

class MainScreen() : Screen, KoinComponent {

    @Composable
    override fun Content() {
//        val sdk : ConticSDK by inject()
        val repository = ConticRepository()

        val context = LocalContext.current
        val navigator = LocalNavigator.currentOrThrow
        val emptyContics = Contics("", emptyList())


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
            repository.getContics()
        }
        val contics by repository.contics.collectAsState(initial = emptyContics)
        if (contics != emptyContics) {
//            Box(modifier = Modifier.fillMaxSize()) {
//                Column() {
//                    Text(text = contics.intro)
//                    Button(onClick = {
//                        navigator.push(NextScreen())
//                    }) {
//                        Text(text = "Next")
//                    }
//                }
//            }
            MainContent(
                contics = contics,
                onClick = { navigator.push(NextScreen())}
            )
        } else{
            LoadingContent()
        }

    }
}

//class FeedListScreen : Screen, KoinComponent {
//    @Composable
//    override fun Content() {
//        val store: FeedStore by inject()
//        FeedList(store = store)
//    }
//}