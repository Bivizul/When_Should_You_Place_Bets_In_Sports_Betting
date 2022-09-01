package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import coil.compose.AsyncImage
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.util.BackImage
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.util.Conspliska

@Composable
fun LoadingContent() {

    Log.e("qwer","LoadingContent")

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        BackImage()
        CircularProgressIndicator()
    }
}