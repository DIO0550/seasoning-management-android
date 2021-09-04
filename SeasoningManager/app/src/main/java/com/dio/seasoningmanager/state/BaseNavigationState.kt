package com.dio.seasoningmanager.state

abstract class BaseNavigationState {
    public open fun entry() { /** do nothing */ }
    public open fun exit() { /** do nothing */ }
    public open fun updateToolbar() { /** do nothing */ }
}