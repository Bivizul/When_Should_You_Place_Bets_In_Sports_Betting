package com.bivizul.whenshouldyouplacebetsinsportsbetting.android.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Color.Gray,
    primaryVariant = Color.DarkGray,
    onPrimary = Color.Black,
    surface = TranspBlack,
)

private val LightColorPalette = lightColors(
    primary = Color.LightGray,
    primaryVariant = Color.DarkGray,
    onPrimary = Color.White,
    surface = TranspWhite,

)

@Composable
fun WhenWhouldYouPlaceBetsInSportsBetting(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

//    val systemUiController = rememberSystemUiController()

//    if(darkTheme){
//        systemUiController.setSystemBarsColor(
//            color = DarkColorPalette.primaryVariant
//        )
//    }else{
//        systemUiController.setSystemBarsColor(
//            color = LightColorPalette.primaryVariant
//        )
//    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}