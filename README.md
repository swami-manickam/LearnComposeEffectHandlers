# Compose-Effect-Handlers

ComposeEffectHandlers android app to show the different types of effect handlers in Android Compose.

### The following effect Handlers are integrated in this project :
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
- LaunchedEffect executes a side effect in a separate coroutine scope, and is useful for executing long-running operations without blocking the UI thread. 
- It triggers on first composition or key change.
### Use Cases ###
- Fetching Data from a Network 
- Performing Image Processing 
- Updating a Database

### Remember Coroutine Scope
- With rememberCoroutineScope which is also Composable function we can get a reference to Coroutine Scope that is aware of the composition here
- as soon as this composable here is actually leaves the composition the coroutine here in all the coroutines in the scope are actually cancelled
- if you actually for example click on button here you can see you can simply launch coroutine inside of a composable function
- any kind of suspending calls to network calls whatever and you are actually safe to do that
### Use Cases ###
- onClicks 
- Animations 
- Callbacks

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
### Use Cases of DisposableEffect ###
- Adding and removing event listeners 
- Starting and stopping animations 
- Bind and unbinding sensors resources such as Camera, LocationManager, etc 
- Managing database connections

### DerivedStateOf

### ProduceState
- produceState allows you to convert non-Compose state into Compose State. 
- It launches a coroutine scoped to the Composition that can push values into the returned State using the value property
- produceState also takes keys to cancel and restart the computation.

### Side Effect
- SideEffect is executed when its parent Composable is recomposed and is useful for executing operations that do not depend on the Composable's state or props.
### Use Cases of SideEffect ###
- Logging and Analytics
- Performing One-Time Initialization such as setting up a connection to a Bluetooth device, loading data from a file, or initializing a library.


### SnapShotFlow
