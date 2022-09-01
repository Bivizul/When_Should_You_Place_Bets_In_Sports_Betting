package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.util

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import coil.compose.AsyncImage

@Composable
fun BackImage(
    modifier: Modifier = Modifier,
) {
    val orientation = LocalConfiguration.current.orientation
    val imageBack = when (orientation) {
        Configuration.ORIENTATION_PORTRAIT -> Conspliska.IMAGE_V
        else -> Conspliska.IMAGE_H
    }
    AsyncImage(
        model = imageBack,
        contentDescription = null,
        modifier = modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}