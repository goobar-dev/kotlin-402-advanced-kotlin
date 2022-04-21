package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

// We can create more complex Flows using a flow builder
// This lets us generate flow values in more complex ways

// Here, we can simulate making a network request, or DB operation by suspending
// for 1 second, and then emitting the new value.  In this case, it means we will
// emit 1 programming language per second
private fun getProgrammingLanguages(): Flow<String> = flow {
    languages.forEach {
        delay(1000)
        emit(it)
    }
}

// Because we collect the values within the CoroutineScope, it doesn't matter if
// they return instantly, or are delayed.  Our CoroutineScope will remain active
// until the Flow completes
private fun main() = runBlocking {
    getProgrammingLanguages().collect { println(it) }
}