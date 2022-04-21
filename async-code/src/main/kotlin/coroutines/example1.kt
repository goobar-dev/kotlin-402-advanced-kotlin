package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// Adding the suspend keyword identifies a function as a "suspending function"
// Suspending functions can call other suspending functions, and they may
// suspend execution of a coroutine for some time, then resume execution at a
// later point
private suspend fun helloWorld() {
    println("Hello World!")
}

// Suspending functions must be called from within a coroutine
// To create a new coroutine, we need a CoroutineScope.  The CoroutineScope
// will control the lifecycle of the coroutine.  There are multiple ways to
// get a CoroutineScope, but the easiest for our example is to access
// GlobalScope with will remain active for the lifetime of our application
private fun main() {
    GlobalScope.launch { helloWorld() } // what happens when we run this code?
}