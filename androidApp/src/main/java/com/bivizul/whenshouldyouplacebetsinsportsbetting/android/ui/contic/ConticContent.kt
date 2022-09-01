package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.contic

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.conticdetail.ConticDetailScreen
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.theme.Typography
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.util.BackImage
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.ConticItem
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Contics

@Composable
fun ConticContent(
    modifier: Modifier = Modifier,
    contics: Contics,
) {

    val navigator = LocalNavigator.currentOrThrow

    Scaffold(modifier = modifier.fillMaxSize()) {
        BackImage()
        LazyColumn() {
            items(contics.conticItem) { conticItem ->
                ConticContentItem(
                    conticItem = conticItem,
                    onClick = {
                        navigator.push(
                            ConticDetailScreen(
                                conticItem = conticItem,
                            )
                        )
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ConticContentItem(
    modifier: Modifier = Modifier,
    conticItem: ConticItem,
    onClick: () -> Unit,
) {

    Card(
        onClick = onClick,
        modifier = modifier
            .padding(4.dp)
    ) {
        Column(modifier = modifier
            .height(80.dp)
            .padding(4.dp)) {
            Text(text = conticItem.title, style = Typography.h6)
            Text(
                text = conticItem.desc,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}
