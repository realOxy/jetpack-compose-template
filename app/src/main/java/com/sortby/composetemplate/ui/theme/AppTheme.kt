package com.sortby.composetemplate.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import com.sortby.composetemplate.ui.Duration
import com.sortby.composetemplate.ui.LocalDuration
import com.sortby.composetemplate.ui.LocalSpacing
import com.sortby.composetemplate.ui.Spacing

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
        MaterialTheme(
            content = content
        )
    }
}