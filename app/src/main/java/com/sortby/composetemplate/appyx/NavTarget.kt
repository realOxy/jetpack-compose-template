package com.sortby.composetemplate.appyx

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed interface NavTarget : Parcelable {
    @Parcelize
    object Main : NavTarget

    // TODO: Add more screen objects or data classes here
}
