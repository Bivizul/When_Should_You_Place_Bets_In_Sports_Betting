package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.main

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import coil.compose.AsyncImage
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.LoadingContent
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.contic.ConticScreen
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Contics
import com.bivizul.whenshouldyouplacebetsinsportsbetting.repository.ConticRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainScreen() : Screen, KoinComponent {

    @Composable
    override fun Content() {

        val repository = ConticRepository()
//        val repository : ConticRepository by inject()

        val context = LocalContext.current
        val activity = LocalContext.current as Activity
        val navigator = LocalNavigator.currentOrThrow
        val emptyContics = Contics("", emptyList())

        BackHandler() {
            activity.finishAndRemoveTask()
            System.exit(0)
        }

        LaunchedEffect(Unit) {
            repository.getContics()
        }
        val contics by repository.contics.collectAsState(initial = emptyContics)
        if (contics != emptyContics) {
            MainContent(
                contics = contics,
                onClick = { navigator.push(ConticScreen())}
            )
        } else{
            LoadingContent()
        }
    }
}