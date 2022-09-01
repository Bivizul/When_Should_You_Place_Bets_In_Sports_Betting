package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.util.BackImage

@Composable
fun LoadingContent(
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        BackImage()
        CircularProgressIndicator()
    }
}