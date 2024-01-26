package com.learn.effecthandlers.launchedeffect

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import java.util.UUID


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

private var i = 0

@Composable
fun LaunchedEffectDemo() {
    var text by remember { mutableStateOf("") }

    LaunchedEffect(key1 = text) {
        i++
    }

    Column {
        Button(onClick = { text += "@" }) {
            Text(text)
        }
    }

}


@Composable
fun LaunchedEffectDemo2() {

    // Use a random UUID as the key for LaunchedEffect
    val key = remember { UUID.randomUUID().toString() }
    val isLoading = remember { mutableStateOf(false) }
    val data = remember { mutableStateOf(listOf<String>()) }


    // Define a LaunchedEffect to perform a long-running operation asynchronously
    // `LaunchedEffect` will cancel and re-launch if
    // `isLoading.value` changes
    LaunchedEffect(key,isLoading.value) {
        if (isLoading.value) {
            // Perform a long-running operation, such as fetching data from a network
            val newData = fetchData()
            // Update the state with the new data
            data.value = newData
            isLoading.value = false
        }
    }

    //
    Column {
        Button(onClick = {isLoading.value = true}) {
            Text(text = "Fetch Data")
        }

        if(isLoading.value)
        // Show a loading indicator
            CircularProgressIndicator()
        else {
            // Show the data
            LazyColumn() {
                items(data.value.size){index-> 
                    Text(text = data.value[index])
                }
            }
        }
            
    }

}


// Simulate a network call by suspending the coroutine for 2 seconds
private suspend fun fetchData(): List<String> {
    // Simulate a network delay
    delay(2000)
    return listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5",)
}