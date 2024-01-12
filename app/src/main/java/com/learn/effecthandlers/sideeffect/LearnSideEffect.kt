package com.learn.effecthandlers.sideeffect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect


@Composable
fun LearnSideEffect(nonComposeCounter :Int) {


    SideEffect {
        println("Called after every successful recomposition")
    }



}