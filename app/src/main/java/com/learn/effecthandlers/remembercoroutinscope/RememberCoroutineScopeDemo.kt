package com.learn.effecthandlers.remembercoroutinscope

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RememberCoroutineScopeDemo() {

    val scope = rememberCoroutineScope()
    Button(onClick = {
        scope.launch {
            delay(1000L)
            println("Hello World")
        }
    }) {
        Text(text = "Print HelloWorld")
    }

}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun RememberCoroutineScopeDemo1() {

    val counter = rememberSaveable { mutableStateOf(0) }
    val coroutineScope = rememberCoroutineScope()

    var text = "Counter is running ${counter.value}"
    if (counter.value == 10) text = "Counter Stopped"

    Column {
        Text(text = text)
        Button(onClick = {
            coroutineScope.launch {

                try {
                    for (i in 1..10) {
                        counter.value++
                        delay(1000)
                    }
                } catch (e: Exception) {

                }
            }
        }) {

            Text(
                text = "START"
            )
        }
    }

}