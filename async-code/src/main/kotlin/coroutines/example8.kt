package coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Uncaught exceptions will terminate execution of your application.
// Basic principles of catching possible known exceptions apply
// whether running in, or outside, of a coroutine.

// In this example, we kick of a coupe different coroutines that run
// sequentially and then ultimately our program finishes
private fun main(): Unit = runBlocking {
    coroutineScope {
        launch { println("1") }
        launch { println("2") }
        //throw RuntimeException()
    }

    println("Finished")
}

// But what happens if an exception is thrown within the call to coroutineScope{}?
// The uncaught exception will propagate to its parent, which in turn, will terminate
// all sibling coroutines as well
//private fun main(): Unit = runBlocking {
//    coroutineScope {
//        launch { println("1") }
//        launch { println("2") }
//        throw RuntimeException()
//    }
//
//    println("Finished")
//}

//private fun main(): Unit = runBlocking {
//    coroutineScope {
//        launch { println("1") }
//        launch { println("2") }
//        try {
//            throw RuntimeException()
//        } catch (error: RuntimeException) {
//            println("Caught an error")
//        }
//    }
//
//    println("Finished")
//}