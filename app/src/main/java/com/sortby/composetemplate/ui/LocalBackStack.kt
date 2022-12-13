package com.sortby.composetemplate.ui

import androidx.compose.runtime.staticCompositionLocalOf
import com.bumble.appyx.navmodel.backstack.BackStack
import com.sortby.composetemplate.appyx.NavTarget

val LocalBackStack = staticCompositionLocalOf<BackStack<NavTarget>> {
    error("No backstack provided.")
}