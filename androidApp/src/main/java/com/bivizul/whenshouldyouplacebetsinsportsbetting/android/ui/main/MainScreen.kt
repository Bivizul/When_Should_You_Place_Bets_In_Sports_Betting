package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.main

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.LoadingContent
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.contic.ConticScreen
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Contics
import com.bivizul.whenshouldyouplacebetsinsportsbetting.network.repository.ConticRepository

class MainScreen() : Screen {

    @Composable
    override fun Content() {

        val repository = ConticRepository()
        val activity = LocalContext.current as Activity
        val navigator = LocalNavigator.currentOrThrow
        val emptyContics = Contics("", emptyList())
        val contics by repository.contics.collectAsState(initial = emptyContics)

        BackHandler() {
            activity.finishAndRemoveTask()
            System.exit(0)
        }
        LaunchedEffect(Unit) {
            repository.getContics()
        }
        if (contics != emptyContics) {
            MainContent(
                contics = contics,
                onClick = { navigator.push(ConticScreen()) }
            )
        } else {
            LoadingContent()
        }
    }
}