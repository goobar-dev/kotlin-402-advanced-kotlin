package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private suspend fun helloWorld() {
    delay(1000)
    println("Hello World!")
}

/**
 * Update main() so that the output of helloWorld() is printed to the console
 */
private fun main() {
    GlobalScope.launch { helloWorld() }
}