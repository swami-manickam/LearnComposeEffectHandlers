package com.learn.effecthandlers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learn.effecthandlers.launchedeffect.LaunchedEffectFlowDemo
import com.learn.effecthandlers.launchedeffect.LaunchedEffectViewModel
import com.learn.effecthandlers.ui.theme.ComposeEffectHandlersAppTheme
import kotlinx.coroutines.delay


var i =0
class MainActivity : ComponentActivity() {

    val viewModel : LaunchedEffectViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeEffectHandlersAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /*Greeting("Android")*/
                    LaunchedEffectFlowDemo(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }


    Box (modifier = modifier
        .fillMaxWidth()
        .height(100.dp)){
        Button(onClick = { text += "#" }) {

            //What is the problem here is we are increasing the i here that could be considered as SideEffect
            //because that is something that escape the scope of composable function. this i has nothing to do with composable
            //its not compose state or anything else we would want here the problem is the approach is super simple example
            //imagine there could be network call you are calling a network function here then whenever this function is here recompose
            //you actual re executes the network and you have no influence on about how often when the function recompose and re trigger the network calls in this case
            // In this case specifically it could recompose more often that's something just avoid the non compose thing in compose code,
            // So what can we do avoid this We can use EffectHandlers
            // because something sometimes we just have to do things that would escape the scope of composable function for example
            //if you want to collect the flow or so but directly doing this in the composable is a terrible practice really never do this
            // however we have these effect handlers here which i will now go through step by step
            // i will explain all of them as i said you will find jump marks and
            // after this example you will really know and understand effect handlers when you should which  which are rather important
            // which are rather rarely used
            // Most commonly used one is LaunchedEffect
            i++
            Text(text = text)
        }
    }

    
    LaunchedEffect(key1 = text ){
        delay(100)
    }
    
    
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeEffectHandlersAppTheme {
        Greeting("Android")
    }
}