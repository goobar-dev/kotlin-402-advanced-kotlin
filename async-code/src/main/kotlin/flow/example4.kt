package flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking

// What if we want to change the thread that will be used to calculate values in the Flow?
// We can do this at collection time by calling flowOn() and passing in a CoroutineContext

// When we run this code, notice that both generation of the value, and collection of the
// value are happening on the main thread.
private fun main() = runBlocking {
    getProgrammingLanguages()
        .collect {
            println("collect $it on thread ${Thread.currentThread().name}")
        }
}

// But what if we wanted to move the generation to a different thread?

// Here, we've moved the calculation of the value to the IO thread pool, while
// collection still happens on the main thread
//private fun main() = runBlocking {
//    getProgrammingLanguages()
//        .flowOn(Dispatchers.IO)
//        .collect {
//            println("collect $it on thread ${Thread.currentThread().name}")
//        }
//}

private suspend fun getProgrammingLanguages(): Flow<String> = flow {
    languages.forEach {
        println("flow $it on thread ${Thread.currentThread().name}")
        delay(1000)
        emit(it)
    }
}