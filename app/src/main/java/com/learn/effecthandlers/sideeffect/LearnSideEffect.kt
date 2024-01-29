package com.learn.effecthandlers.sideeffect

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlin.math.log


@Composable
fun LearnSideEffect(nonComposeCounter :Int) {


    SideEffect {
        println("Called after every successful recomposition")
    }


}

@Composable
fun LearnSideEffectDemo() {

    val counter = remember { mutableStateOf(0) }

    // Use SideEffect to log the current value of count
    SideEffect {
        // Called on every recomposition
        Log.e( "LearnSideEffectDemo Count is: ","${counter.value}")
    }

    Column {
        Button(onClick = { counter.value++}) {
            Text(text = "Increase Count")
        }

        // Use SideEffect to log the current value of count
        SideEffect {
            // Called on every recomposition
            Log.e("Inner Count is","${counter.value}")
        }

        // This recomposition doesn't trigger the outer side effect
        // every time button has been tapped
        Text(text = "Increase Counter ${counter.value}")
    }


}