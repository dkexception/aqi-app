package com.dkexception.ui.lifecycle

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver

@Composable
fun LifecycleObserver.ComposableLifecycleListener() {

    val lifecycle: Lifecycle = LocalLifecycleOwner.current.lifecycle

    DisposableEffect(lifecycle) {

        lifecycle.addObserver(this@ComposableLifecycleListener)

        onDispose {
            lifecycle.removeObserver(this@ComposableLifecycleListener)
        }
    }
}
