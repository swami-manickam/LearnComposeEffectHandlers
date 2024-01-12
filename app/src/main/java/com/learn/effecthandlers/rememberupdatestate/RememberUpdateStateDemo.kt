package com.learn.effecthandlers.rememberupdatestate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

// Imagine you have Splash Screen that would be your splash screen composable
// then you have lambda function on timeout that gets triggered as soon as you delay for the splash screen
//this composable called with different timeout function this launched effect block would not consider
// the new timeout because it was launched with the old one and since we do not pass this on
// timeout function for the key because we do not want this block to be relaunched
// when on timer changes which would then extend the duration of our splash screen because of that
// it would actually all not really override this on timeout function and for that we have something called remember update state
//



@Composable
fun RememberUpdateStateDemo(onTimeOut: () -> Unit) {
    val updateOnTimeOut by  rememberUpdatedState(newValue = onTimeOut)
    LaunchedEffect(key1 = true) {
        delay(4000L)
        updateOnTimeOut()
    }

}