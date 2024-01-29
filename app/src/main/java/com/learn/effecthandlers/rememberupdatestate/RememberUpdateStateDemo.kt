package com.learn.effecthandlers.rememberupdatestate

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay



@Composable
fun RememberUpdateStateDemo(onTimeOut: () -> Unit) {
    val updateOnTimeOut by  rememberUpdatedState(newValue = onTimeOut)
    LaunchedEffect(key1 = true) {
        delay(4000L)
        updateOnTimeOut()
    }

}


@Composable
fun RememberUpdateStateDemo1() {

    var isChecked by rememberSaveable { mutableStateOf(false) }
    
    Button(onClick = { isChecked = !isChecked }) {
        Text(text = if (isChecked) "ON" else "OFF")
    }

}