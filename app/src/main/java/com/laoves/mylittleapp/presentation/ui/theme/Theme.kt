package com.laoves.mylittleapp.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = colorPrimary,
    background = darkGray,
    onBackground = textWhite,
    onPrimary = darkGray
)

private val LightColorPalette = lightColors(
    primary = colorPrimary,
    background = Color.White,
    onBackground = mediumGray,
    onPrimary = darkGray
)

@Composable
fun MyLittleAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}