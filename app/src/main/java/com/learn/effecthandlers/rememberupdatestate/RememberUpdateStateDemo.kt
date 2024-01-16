package com.learn.effecthandlers.rememberupdatestate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay



@Composable
fun RememberUpdateStateDemo(onTimeOut: () -> Unit) {
    val updateOnTimeOut by  rememberUpdatedState(newValue = onTimeOut)
    LaunchedEffect(key1 = true) {
        delay(4000L)
        updateOnTimeOut()
    }

}