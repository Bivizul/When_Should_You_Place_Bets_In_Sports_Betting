package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.conticdetail

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.ConticItem

class ConticDetailScreen(val conticItem: ConticItem) : Screen {

    @Composable
    override fun Content() {
        ConticDetailContent(
            conticItem = conticItem,
        )
    }

}

