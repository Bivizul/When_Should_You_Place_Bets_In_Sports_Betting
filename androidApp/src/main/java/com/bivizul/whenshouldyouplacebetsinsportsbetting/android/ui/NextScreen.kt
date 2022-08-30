package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
//import cafe.adriel.voyager.androidx.AndroidScreen

class NextScreen() : Screen {

    @Composable
    override fun Content() {
        Log.e("qwer","NextScreen")
        Box(modifier = Modifier.fillMaxSize()){
            Text(text = "NextScreen")
        }
    }
}