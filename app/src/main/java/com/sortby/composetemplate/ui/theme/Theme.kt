package com.sortby.composetemplate.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.sortby.composetemplate.ui.Duration
import com.sortby.composetemplate.ui.LocalDuration
import com.sortby.composetemplate.ui.LocalSpacing
import com.sortby.composetemplate.ui.Spacing

/**
 * The basic composable theme wrapper.
 */
@Composable
fun AppTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    lightTheme: ComposeTheme = frigidity,
    darkTheme: ComposeTheme = midNight,
    content: @Composable () -> Unit
) {
    val colors = remember(useDarkTheme) {
        if (useDarkTheme) darkTheme else lightTheme
    }

    CompositionLocalProvider(
        LocalSpacing provides Spacing(),
        LocalTheme provides colors,
        LocalDuration provides Duration()
    ) {
        MaterialTheme(content = content)
    }
}

/**
 * App theme colors
 * @param name This theme's name.
 * @param isDark This theme is a dark theme or not.
 * @param isDarkText System bar icon and text is dark or not.
 * @param tint The main color.
 * @param onTint The main content color.
 * @param tintDisable The disabled main color.
 * @param onTintDisable The disabled main content color.
 * @param primary The primary active color.
 * @param onPrimary The primary active content color.
 * @param secondary The secondary active color.
 * @param onSecondary The secondary active content color.
 * @param surface The surface color.
 * @param onSurface The surface content color.
 * @param topBar The topBar color.
 * @param onTopBar The topBar content color.
 * @param topBarDisable The disabled topBar color.
 * @param onTopBarDisable The disabled topBar content color.
 * @param background The background color.
 * @param onBackground The background content color.
 * @param secondaryBackground The secondary background color, its content color shouldn't exist.
 * @param pressed The pressed color.
 * @param onPressed The pressed content color.
 * @param error The error color.
 * @param onError The error content color.
 * @param divider The divider color.
 * @param id The theme id, preset theme should always -1.
 * @see Color
 * @sample [seaSalt]
 * @sample [midNight]
 * @sample [frigidity]
 */
data class ComposeTheme(
    val name: String,
    val isDark: Boolean,
    val isDarkText: Boolean = !isDark,
    val tint: Color,
    val onTint: Color,
    val tintDisable: Color,
    val onTintDisable: Color,
    val primary: Color,
    val onPrimary: Color,
    val secondary: Color,
    val onSecondary: Color,
    val surface: Color,
    val onSurface: Color,
    val topBar: Color,
    val onTopBar: Color,
    val topBarDisable: Color,
    val onTopBarDisable: Color,
    val background: Color,
    val onBackground: Color,
    val secondaryBackground: Color,
    val pressed: Color,
    val onPressed: Color,
    val error: Color,
    val onError: Color,
    val divider: Color,
    val id: Int = -1
)

val seaSalt = ComposeTheme(
    name = "sea salt",
    isDark = false,
    tint = Color(0xff837fc9),
    onTint = Color(0xffeef7fb),
    tintDisable = Color(0xffc7c6cb),
    onTintDisable = Color(0xfff6f5f9),
    primary = Color(0xff5a91de),
    onPrimary = Color(0xffdcf7fa),
    secondary = Color(0xffefefef),
    onSecondary = Color(0xff000000),
    surface = Color(0xFFeeeeee),
    onSurface = Color(0xFF191C1B),
    topBar = Color(0xFFeeeeee),
    onTopBar = Color(0xFF191C1B),
    topBarDisable = Color(0xff837fc9),
    onTopBarDisable = Color(0xffeef7fb),
    background = Color(0xfffefefe),
    onBackground = Color(0xff2a2a2a),
    secondaryBackground = Color(0xff7eb2a8),
    pressed = Color(0xfff8f8f8),
    onPressed = Color(0xff323232),
    error = Color(0xFFBA1A1A),
    onError = Color.White,
    divider = Color(0xFFf0f0f0)
)
val midNight = ComposeTheme(
    name = "mid night",
    isDark = true,
    tint = Color(0xff42b6fe),
    onTint = Color(0xffffffff),
    tintDisable = Color(0xff8e8e8e),
    onTintDisable = Color(0xff8e8e8e),
    primary = Color(0xff387ab4),
    onPrimary = Color(0xffeef5f9),
    secondary = Color(0xff202123),
    onSecondary = Color(0xffffffff),
    surface = Color(0xff232325),
    onSurface = Color(0xFFffffff),
    topBar = Color(0xff232325),
    onTopBar = Color(0xFFffffff),
    topBarDisable = Color(0xff232325),
    onTopBarDisable = Color(0xFFffffff),
    background = Color(0xff181818),
    onBackground = Color(0xffffffff),
    secondaryBackground = Color(0xff141622),
    pressed = Color(0xff222222),
    onPressed = Color(0xff323232),
    error = Color(0xfff2b8b5),
    onError = Color(0xff601410),
    divider = Color(0xFF0A0A0A)
)

val frigidity = ComposeTheme(
    name = "frigidity",
    isDark = false,
    isDarkText = false,
    tint = Color(0xff81a0f3),
    onTint = Color(0xfffcfcf5),
    tintDisable = Color(0xfff6f6f6),
    onTintDisable = Color(0xff81a0f3),
    primary = Color(0xfffdf2d4),
    onPrimary = Color(0xffba8800),
    secondary = Color(0xfffefefe),
    onSecondary = Color(0xff0f0f0f),
    surface = Color(0xFFeeeeee),
    onSurface = Color(0xFF191C1B),
    topBar = Color(0xff6877ad),
    onTopBar = Color(0xFFffffff),
    topBarDisable = Color(0xff7388c9),
    onTopBarDisable = Color(0xFFffffff),
    background = Color(0xffffffff),
    onBackground = Color(0xff000000),
    secondaryBackground = Color(0xffcdd6df),
    pressed = Color(0xff222222),
    onPressed = Color(0xff323232),
    error = Color(0xFFBA1A1A),
    onError = Color.White,
    divider = Color(0xFFefefef)
)

val allPresetThemes = listOf(
    seaSalt, midNight, frigidity
)

val LocalTheme = staticCompositionLocalOf { frigidity }