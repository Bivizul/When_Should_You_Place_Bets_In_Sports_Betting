package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.contic

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.LoadingContent
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Contics
import com.bivizul.whenshouldyouplacebetsinsportsbetting.repository.ConticRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ConticScreen() : Screen, KoinComponent {

    @Composable
    override fun Content() {
        val repository = ConticRepository()
//        val repository: ConticRepository by inject()

        val context = LocalContext.current
        val navigator = LocalNavigator.currentOrThrow
        val emptyContics = Contics("", emptyList())

        LaunchedEffect(Unit) {
            repository.getContics()
        }

        val contics by repository.contics.collectAsState(initial = emptyContics)

        if (contics != emptyContics) {
//            MainContent(
//                contics = contics,
//                onClick = { navigator.push(ConticScreen())}
//            )
            ConticContent(
                contics = contics
            )
        } else {
            LoadingContent()
        }
    }
}