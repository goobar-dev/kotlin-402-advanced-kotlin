package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

private suspend fun helloWorld() {
    println("helloWorld() running in ${Thread.currentThread().name}")
    println("Hello World!")
}

// In the previous example, our "Hello World!" message was never printed to the console
// This is because the call to launch{} creates a coroutine that, by default, is operating
// in a different thread that our main() function.

// To highlight this, we can add some log messages that print the thread names

// To fix this, we could simply call sleep() right after we launch the coroutine.  This
// will give the coroutine a chance to run before the program terminates
private fun main() {
    println("main() running in ${Thread.currentThread().name}")
    GlobalScope.launch { helloWorld() }
    Thread.sleep(1000)
}