package br.com.francivaldo.prumodigital.view.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Primary,
    primaryVariant = Primary,
    secondary = Secundary,
    background = Background,
    surface = Secundary,
    onPrimary = OnColor,
    onSecondary = OnColor,
    onBackground = OnColor,
    onSurface = OnColor,
)

@Composable
fun PrumoDigitalTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = DarkColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}