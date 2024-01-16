# Compose-Effect-Handlers

ComposeEffectHandlers android app to show the different types of effect handlers in Android Compose.

### The following effects are integrated in this project :
1. Launched Effect 
2. Remember Coroutine Scope 
3. Remember Update State 
4. Disposable Effect 
5. DerivedStateOf 
6. ProduceState 
7. Side Effect 
8. SnapShotFlow


### Launched Effect:
- To call suspend functions safely from inside a composable, use the LaunchedEffect composable. 
- When LaunchedEffect enters the Composition, it launches a coroutine with the block of code passed as a parameter. 
- The coroutine will be cancelled if LaunchedEffect leaves the composition. 
- If LaunchedEffect is recomposed with different keys, the existing coroutine will be cancelled and the new suspend function will be launched in a new coroutine.
- LaunchedEffect restarts when one of the key parameters changes.
- As LaunchedEffect is a composable function, it can only be used inside other composable functions

### Remember Coroutine Scope
- With rememberCoroutineScope which is also Composable function we can get a reference to Coroutine Scope that is aware of the composition here
- as soon as this composable here is actually leaves the composition the coroutine here in all the coroutines in the scope are actually cancelled
- if you actually for example click on button here you can see you can simply launch coroutine inside of a composable function
- any kind of suspending calls to network calls whatever and you are actually safe to do that

### Remember Update State
- Imagine you have Splash Screen that would be your splash screen composable then you have lambda function on timeout that gets triggered as soon as you delay for the splash screen
- this composable called with different timeout function this launched effect block would not consider the new timeout 
- because it was launched with the old one and since we do not pass this on 
- timeout function for the key because we do not want this block to be relaunched 
- when on timer changes which would then extend the duration of our splash screen because of that 
- it would actually all not really override this on timeout function and for that we have something called remember update state

### Disposable Effect
- For side effects that need to be cleaned up after the keys change or if the composable leaves the Composition
- Observer that needs to be cleaned up after being used like if the composer leaves the composition we do not want to use the observer anymore we need to dispose it

### DerivedStateOf

### ProduceState

### Side Effect


### SnapShotFlow
