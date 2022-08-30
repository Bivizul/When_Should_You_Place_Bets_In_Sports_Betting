package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.main

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Contics

@Composable
fun MainContent(
    contics: Contics,
//    navigator:Navigator,
    onClick: () -> Unit
) {

    Log.e("qwer","MainContent")

    Box(modifier = Modifier.fillMaxSize()) {
        Column() {
            Text(text = contics.intro)
            Button(
//                onClick = {
//                navigator.push(NextScreen())
//                }
                onClick = onClick
            ) {
                Text(text = "Next")
            }
//            Text(
//                text = instance.toString().substringAfterLast('.'),
//                style = MaterialTheme.typography.body2
//            )
        }
    }
}