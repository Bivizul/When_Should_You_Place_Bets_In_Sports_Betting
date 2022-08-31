package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.bivizul.whenshouldyouplacebetsinsportsbetting.core.entity.ConticItem
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun ConticList(
    modifier: Modifier,
    conticItems: List<ConticItem>,
    listState: LazyListState,
    onClick: (ConticItem) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        state = listState
    ) {
        itemsIndexed(conticItems) { i, contic ->
            if (i == 0) Spacer(Modifier.windowInsetsTopHeight(WindowInsets.statusBars))
            ConticItem(contic) { onClick(contic) }
            if (i != conticItems.size - 1) Spacer(modifier = Modifier.size(16.dp))
        }
    }
}

private val dateFormatter = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())

@Composable
fun ConticItem(
    item: ConticItem,
    onClick: () -> Unit
) {
    val padding = 16.dp
    Box {
        Card(
            elevation = 16.dp,
            shape = RoundedCornerShape(padding)
        ) {
            Column(
                modifier = Modifier.clickable(onClick = onClick)
            ) {
                Spacer(modifier = Modifier.size(padding))
                Text(
                    modifier = Modifier.padding(start = padding, end = padding),
                    style = MaterialTheme.typography.h6,
                    text = item.title
                )
//                item.imageUrl?.let { url ->
//                    Spacer(modifier = Modifier.size(padding))
//                    Image(
//                        painter = rememberAsyncImagePainter(url),
//                        modifier = Modifier.height(180.dp).fillMaxWidth(),
//                        contentDescription = null
//                    )
//                }
                item.desc?.let { desc ->
                    Spacer(modifier = Modifier.size(padding))
                    Text(
                        modifier = Modifier.padding(start = padding, end = padding),
                        style = MaterialTheme.typography.body1,
                        maxLines = 5,
                        overflow = TextOverflow.Ellipsis,
                        text = desc
                    )
                }
                Spacer(modifier = Modifier.size(padding))
//                Text(
//                    modifier = Modifier.padding(start = padding, end = padding),
//                    style = MaterialTheme.typography.body2,
//                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
//                    text = dateFormatter.format(Date(item.date))
//                )
//                Spacer(modifier = Modifier.size(padding))
            }
        }
    }
}