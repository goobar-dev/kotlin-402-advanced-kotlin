package coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

private fun main(): Unit = runBlocking {
    println("Start counting")
    countToN(3)
    println("Done counting")
}

/**
 * Update [countToN] so it sequentially prints out all numbers from 0 to [n] - 1 second at a time
 * An N of 5 should take 5 seconds to complete
 */
private suspend fun countToN(n: Int) {
    TODO()
}