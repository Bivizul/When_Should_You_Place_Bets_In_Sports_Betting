package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.conticdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.theme.Typography
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.util.BackImage
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.ConticItem

@Composable
fun ConticDetailContent(
    modifier: Modifier = Modifier,
    conticItem: ConticItem,
) {
    val scrollState = rememberScrollState()

    Scaffold(modifier = modifier) {
        BackImage()
        Column(
            modifier = modifier
                .background(MaterialTheme.colors.background)
                .padding(8.dp)
                .fillMaxSize()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = conticItem.title,
                modifier = modifier.padding(16.dp),
                style = Typography.h5
            )
            Text(
                text = conticItem.desc,
                style = Typography.body1
            )
        }
    }
}