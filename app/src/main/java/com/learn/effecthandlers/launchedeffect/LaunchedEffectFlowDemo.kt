package com.learn.effecthandlers.launchedeffect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect


@Composable
fun LaunchedEffectFlowDemo(viewModel: LaunchedEffectViewModel) {

    LaunchedEffect(key1 = true) {
        viewModel.sharedFlow.collect { event ->
            when (event) {
                is LaunchedEffectViewModel.ScreenEvents.ShowSnackBar -> {

                }

                is LaunchedEffectViewModel.ScreenEvents.Navigate -> {

                }
            }
        }
    }
}