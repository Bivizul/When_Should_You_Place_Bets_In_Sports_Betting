package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.conticdetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.theme.Typography
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.util.BackImage
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.ConticItem

@Composable
fun ConticDetailContent(
    modifier: Modifier = Modifier,
    conticItem: ConticItem,
){
    Scaffold(modifier = modifier) {
        BackImage()
        Column(modifier = modifier
            .padding(4.dp)) {
            Text(text = conticItem.title, style = Typography.h5)
            Text(
                text = conticItem.desc,
            )
        }
    }
}