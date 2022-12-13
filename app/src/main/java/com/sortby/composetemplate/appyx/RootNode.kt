package com.sortby.composetemplate.appyx

import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.bumble.appyx.core.composable.Children
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node
import com.bumble.appyx.core.node.ParentNode
import com.bumble.appyx.core.node.node
import com.bumble.appyx.navmodel.backstack.BackStack
import com.bumble.appyx.navmodel.backstack.transitionhandler.rememberBackstackSlider
import com.sortby.composetemplate.screen.main.MainScreen
import com.sortby.composetemplate.ui.LocalBackStack
import com.sortby.composetemplate.ui.LocalDuration
import com.sortby.composetemplate.ui.theme.AppTheme
import com.sortby.composetemplate.ui.theme.LocalTheme

class RootNode(
    buildContext: BuildContext,
    private val backStack: BackStack<NavTarget> = BackStack(
        initialElement = NavTarget.Main,
        savedStateMap = buildContext.savedStateMap
    )
) : ParentNode<NavTarget>(
    buildContext = buildContext,
    navModel = backStack
) {

    @Composable
    override fun View(modifier: Modifier) {
        CompositionLocalProvider(
            LocalBackStack provides backStack
        ) {
            val theme = LocalTheme.current
            val duration = LocalDuration.current
            AppTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .navigationBarsPadding(),
                    color = theme.background,
                    contentColor = theme.onBackground
                ) {
                    Children(
                        navModel = backStack,
                        modifier = modifier,
                        transitionHandler = rememberBackstackSlider(
                            transitionSpec = { tween(duration.medium) }
                        )
                    )
                }
            }
        }
    }

    override fun resolve(navTarget: NavTarget, buildContext: BuildContext): Node {
        return when (navTarget) {
            NavTarget.Main -> node(buildContext) {
                MainScreen(it)
            }
        }
    }
}
