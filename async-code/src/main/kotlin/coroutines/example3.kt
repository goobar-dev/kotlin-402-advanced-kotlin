package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// This function simulates some async call like making a network request or
// loading data from a database.  Here, we suspend the coroutine for 2 seconds
// Because we know how long to delay we were able to call sleep() in the main
// thread to ensure the coroutine finished.  This doesn't scale though.  We
// need ways to ensure that all our coroutines run; regardless of how long they
// take.
private suspend fun helloWorld() {
    delay(2000)
    println("Hello World!")
}

// To help with this, and to help bridge the gap between suspending code, and
// non-suspending code, we can use runBlocking{} to block the current thread
// until all coroutines within the created CoroutineScope have completed.
private fun main(): Unit = runBlocking {
    // Notice we no longer need to use GlobalScope
    // runBlocking{} provides a CoroutineScope as the receive type of the function
    // Within that scope, we can call our suspending function as we'd like.
    // We could also launch new coroutines if we wanted.
    helloWorld()
}