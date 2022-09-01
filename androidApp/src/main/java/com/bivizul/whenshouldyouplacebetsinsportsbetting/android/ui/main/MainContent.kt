package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.R
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.theme.Shapes
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.theme.Typography
import com.bivizul.whenshouldyouplacebetsinsportsbetting.android.util.BackImage
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Contics

@Composable
fun MainContent(
    modifier: Modifier = Modifier,
    contics: Contics,
    onClick: () -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        BackImage()
        Column(
            modifier = modifier
                .background(MaterialTheme.colors.background)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier.weight(0.3f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = Typography.h4,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onBackground
                )
            }
            Box(modifier = Modifier.weight(0.7f)) {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .clip(shape = Shapes.large)
                        .background(MaterialTheme.colors.surface)
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = stringResource(R.string.introduction),
                        style = Typography.h3
                    )
                    Text(
                        text = contics.intro,
                        style = Typography.body1
                    )
                    Button(
                        onClick = onClick
                    ) {
                        Text(
                            text = stringResource(R.string.other_things),
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}
