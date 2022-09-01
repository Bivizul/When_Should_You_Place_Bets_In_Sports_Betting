package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.contic

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.screen.Screen
import com.bivizul.thebeginnersguidetobettingonformula1.util.getSpliskadia
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.LoadingContent
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Contics
import com.bivizul.whenshouldyouplacebetsinsportsbetting.network.repository.ConticRepository

class ConticScreen() : Screen {

    @Composable
    override fun Content() {
        val repository = ConticRepository()
        val emptyContics = Contics("", emptyList())
        val context = LocalContext.current
        val activity = LocalContext.current as Activity

        LaunchedEffect(Unit) {
            try {
                repository.getContics()
            } catch (e: Exception) {
                getSpliskadia(context, activity)
            }
        }
        val contics by repository.contics.collectAsState(initial = emptyContics)
        if (contics != emptyContics) {
            ConticContent(
                contics = contics
            )
        } else {
            LoadingContent()
        }
    }
}