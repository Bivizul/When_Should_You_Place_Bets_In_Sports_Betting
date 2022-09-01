package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.conticdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.theme.Typography
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.ConticItem

class ConticDetailScreen(
    val conticItem: ConticItem,
) : Screen {

    @Composable
    override fun Content() {

        ConticDetailContent(
            conticItem = conticItem,
        )
    }
}

