package coroutines

import kotlinx.coroutines.*


// What if we want to change the CoroutineContext in which we're operating?
// For example, perhaps we want to ensure that a network call always
// happens on an IO thread, while the UI update always happens on the
// main thread?

private val context = newSingleThreadContext("Custom Context")

// Using withContext() we can create a new CoroutineContext that includes a
// new Dispatcher.
suspend fun longRunningTask() = withContext(Dispatchers.IO) {
    println("longRunningTask() running on: ${Thread.currentThread().name}")
    delay(2000)
    updateUI("Kotlin")
}

// When we run this initially, we see that the thread is chaned when
// we call longRunningTask().  Because updateUI() is called from within
// the CoroutineContext created by longRunningTask(), it also runs in
// that same IO thread.
fun main(): Unit  = runBlocking(context) {
    println("main() running on: ${Thread.currentThread().name}")
    longRunningTask()
}

// To ensure that the UI update happens on the main thread, we could
// also use a call to withContext() here and pass the specific
// Dispatcher we're interested in
suspend fun updateUI(name: String) {
    println("updateUI() running on: ${Thread.currentThread().name}")
    // do something with value
}

//suspend fun updateUI(name: String) = withContext(context) {
//    println("updateUI() running on: ${Thread.currentThread().name}")
//    // do something with value
//}