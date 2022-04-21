package flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.runBlocking

// A Flow is a cold stream of async computed values
// Flows are backed by coroutines to allow long running computations without
// blocking in any way.

// We can easily create a flow by converting an existing List to a Flow
private fun getProgrammingLanguages(): Flow<String> {
    return languages.asFlow()
}

// To observe values in a Flow, we must "collect" that flow
// Flow collection must happen within a CoroutineScope
// Here, we simply print out each value in the flow
private fun main(): Unit = runBlocking {
    getProgrammingLanguages().collect {
        println(it)
    }
}