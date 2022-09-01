package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.main

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import coil.compose.AsyncImage
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.util.BackImage
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.util.Conspliska.IMAGE_H
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.util.Conspliska.IMAGE_V
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Contics

@Composable
fun MainContent(
    contics: Contics,
//    navigator:Navigator,
    onClick: () -> Unit
) {

    Log.e("qwer","MainContent")

    Box(modifier = Modifier.fillMaxSize()) {
        BackImage()
        Column() {
            Text(text = contics.intro)
            Button(
//                onClick = {
//                navigator.push(NextScreen())
//                }
                onClick = onClick
            ) {
                Text(text = "Contic")
            }
//            Text(
//                text = instance.toString().substringAfterLast('.'),
//                style = MaterialTheme.typography.body2
//            )
        }
    }
}