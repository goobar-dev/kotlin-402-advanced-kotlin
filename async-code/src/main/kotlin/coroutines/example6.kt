package coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

// Coroutines ultimately run on threads.  There's no escaping the fundamental
// hardware/software architecture.

// A CoroutineContext includes a Dispatcher.  The Dispatcher controls which
// thread a coroutine will execute on.

// We can examine how Dispatchers impact the execution threads, and how
// CoroutineContexts are composed by passing different Dispatches to launch{}

fun main(): Unit = runBlocking {

    // Create a coroutine using the Dispatcher inherited from the current CoroutineScope
    launch {
        println("launch(){} - thread name = ${Thread.currentThread().name}")
    }

    // Create a coroutine with a new Dispatcher
    // Backed by a shared thread pool
    launch(Dispatchers.Default) {
        println("launch(Default){} - thread name = ${Thread.currentThread().name}")

        // Creates a coroutine that inherits Dispatchers.Default
        launch {
            println("launch(Default) - child launch{} - thread name = ${Thread.currentThread().name}")
        }
    }

    launch(Dispatchers.IO) {
        println("launch(IO){} - thread name = ${Thread.currentThread().name}")
    }

    // We can create our own CoroutineContexts backed by customized thread pools
    launch(newSingleThreadContext("CustomThread")) {
        println("launch(newSingleThreadContext()){} - thread name = ${Thread.currentThread().name}")

        // This coroutine will inherit the singleThreadContext from its parent
        launch {
            println("launch(newSingleThreadContext()){} - child - thread name = ${Thread.currentThread().name}")
        }
    }
}