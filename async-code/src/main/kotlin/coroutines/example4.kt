package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Let's look at another example that highlights the orchestration between coroutines and
// threads.

// Here, we use runBlocking{} to ensure all coroutines will complete before the
// application terminates

// However, if we run the code, we'll notice the output isn't what we might expect
// What do we think will happen?

// Similar to previous examples, once the initial launch{} is called, the main()
// function continues to execute as normal.  Once it gets to the last println(),
// it will stay blocked until all coroutines within the runBlocking{} scope are
// finished.

// What we need, is a way to suspend execution of a coroutine, until another
// coroutine(s) have finished
//private fun main(): Unit = runBlocking {
//    println("Starting to count...")
//
//    launch {
//        for (i in 0..3) {
//            launch {
//                delay(1000L * i)
//                println(i)
//            }
//        }
//    }
//
//    println("Done counting")
//}

// To achieve this, and make the output appear in the desired order, we
// can use the job returned by the initial launch{} call.

// A Job is a handle to a coroutine.  We can use it to cancel that coroutine
// and all its children.  Or, we can use it to suspend execution of the
// current coroutine until the job completes
private fun main(): Unit = runBlocking {
    println("Starting to count...")

    val job = launch {
        for (i in 0..3) {
            launch {
                delay(1000L * i)
                println(i)
            }
        }
    }
    job.join() // suspend runBlocking{} until each launched coroutine has completed

    println("Done counting")
}