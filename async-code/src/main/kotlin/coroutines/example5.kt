package coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

// The launch{} builder works well when we don't need to return a value
// from our coroutine. But what if we do?

// The async{} builder can help with this use case.
// Using async{}, we can define new coroutines that will return Deferred
// results.  We can then suspend execution until those results have returned
// This works very similarly to async/await from other languages

// To illustrate this, we've defined 2 suspending functions here that represent
// different long-running tasks we may need to perform together
private suspend fun longRunningTask1(): Int {
    delay(2000)
    return 2
}

private suspend fun longRunningTask2(): Int {
    delay(2000)
    return 3
}

// Here, we've started out by calling each suspending function from within the same
// coroutine.

// If we run this code, notice the run time?  The suspending functions are run
// serially.  What if we wanted to parallelize this work?
private fun main(): Unit = runBlocking {
    val time = measureTimeMillis {
        val one = longRunningTask1()
        val two = longRunningTask2()
        println("The answer is ${one + two}")
    }
    println("Took $time milliseconds")
}

// We can use async() to run both suspending functions at the same time, and
// suspend execution until both values are returned
//private fun main(): Unit = runBlocking {
//    val time = measureTimeMillis {
//        val one = async {  longRunningTask1() }
//        val two = async { longRunningTask2() }
//        println("The answer is ${one.await() + two.await()}")
//    }
//    println("Took $time milliseconds")
//}