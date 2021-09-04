package com.dio.seasoningmanager.state.toolbar

import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar

abstract class BaseToolbarState {
    public open fun updateToolbar(toolbarLayout: FrameLayout) {}
}