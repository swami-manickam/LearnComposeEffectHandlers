package com.learn.effecthandlers.remembercoroutinscope

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


// With rememberCoroutineScope which is also Composable function
// we can get a reference to Coroutine Scope that is aware of the composition here
// as soon as this composable here is actually leaves the composition the coroutine
// here in all the coroutines in the scope are actually cancelled
// if you actually for example click on button here you can see you can simply launch coroutine inside of a composable function
//any kind of suspending calls to network calls whatever and you are actually safe to do that
//You can use only this in callbacks and with callbacks



@Composable
fun RememberCoroutineScopeDemo() {

    val scope = rememberCoroutineScope()
    Button(onClick = {
        scope.launch {
            delay(1000L)
            println("Hello World")
        }
    }) {

    }


}