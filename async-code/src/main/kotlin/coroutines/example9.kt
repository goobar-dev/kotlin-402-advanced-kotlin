package coroutines

import kotlinx.coroutines.*
import java.lang.RuntimeException

// Let's expand on our error handling example
// Here, we're defining a custom CoroutineScope, and then using
// it to launch 4 coroutines.

// One of those coroutines throws an exception, and thereby cause
// some of the sibling coroutines to never complete

//private fun main() = runBlocking {
//    val scope = CoroutineScope(Job())
//
//    val job1 = scope.launch {
//        delay(200)
//        println(1)
//    }
//    val job2 = scope.launch {
//        delay(100)
//        println(2)
//    }
//    val job3 = scope.launch { throw RuntimeException() }
//    val job4 = scope.launch { println(4) }
//
//    joinAll(job1, job2, job3, job4)
//    println("Finished")
//}

// One way to improve this behavior, is to use a SupervisorJob when creating
// the custom CoroutineScope.
// SupervisorJob will prevent an uncaught exception from propagating to sibling
// coroutines within the same scope.

// Notice, that after making this change, all the sibline coroutines now complete
//private fun main() = runBlocking {
//    val scope = CoroutineScope(SupervisorJob())
//
//    val job1 = scope.launch {
//        delay(200)
//        println(1)
//    }
//    val job2 = scope.launch {
//        delay(100)
//        println(2)
//    }
//    val job3 = scope.launch { throw RuntimeException() }
//    val job4 = scope.launch { println(4) }
//
//    joinAll(job1, job2, job3, job4)
//    println("Finished")
//}

// The output from this uncaught exception is still noisy however
// And what if we wanted to log this in some way?
// How could we respond to these uncaught exceptions in some unified way?

// For this, we can define a custom CoroutineExceptionHandler in our
// created CoroutineContext.  This will give us a chance to log the error,
// or do anything else with it we might like.

// Will provide a less noisy error message when an unhandled exception is caught
// within launch{} calls where this is used
val handler = CoroutineExceptionHandler { _, exception ->
    println("Caught $exception")
}

private fun main() = runBlocking {
    val scope = CoroutineScope(SupervisorJob() + handler)

    val job1 = scope.launch {
        delay(200)
        println(1)
    }
    val job2 = scope.launch {
        delay(100)
        println(2)
    }
    val job3 = scope.launch(handler) { throw RuntimeException() }
    val job4 = scope.launch { println(4) }

    joinAll(job1, job2, job3, job4)
    println("Finished")
}