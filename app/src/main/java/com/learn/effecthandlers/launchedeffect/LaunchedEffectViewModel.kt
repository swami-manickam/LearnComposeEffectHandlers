package com.learn.effecthandlers.launchedeffect

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LaunchedEffectViewModel : ViewModel() {

    private val _sharedFlow = MutableSharedFlow<ScreenEvents>()
    val sharedFlow = _sharedFlow.asSharedFlow()


    init {

        //here we emit a new event show snack by event and we want to show the snack bar with text in our screen
        //how can we now collect this flow in our composable because
        // if we would just do shared flow.collect in the composable function itself that would be a side effect
        // because the collect function would be called with every single recomposition and we can control that so
        //what we can do is if we take a look here we can simply use a launch effect block passing through as a key quite true as well
        //if we pass through we make sure its actually only called once so the first time the composable is here composing
        //this launch effect block is executing and its never actually cancelled and relaunched unless the composable
        // here actually leaves the composition and in here we are now safe to actually collect the shared flow
        // because this is now not executed with every recomposition anymore instead only the first time
        // this composable actually enter the screen or is composed for first time and then we can safely collect these events and do something
        // with these like show snack bar or use our nav controller to perform the navigation
        // another example that would actually use such a key here would be to launch an animation
        viewModelScope.launch {
            _sharedFlow.emit(ScreenEvents.ShowSnackBar("HelloWorld"))
        }

    }

    // We have screen events if you want to show snack bar or navigate to different screens
    // we can send these events from view model to ui
    sealed class ScreenEvents {
        data class ShowSnackBar(val message: String) : ScreenEvents()
        data class Navigate(val route: String) : ScreenEvents()
    }


}