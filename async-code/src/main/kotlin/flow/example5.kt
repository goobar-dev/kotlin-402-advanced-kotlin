package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

private val languagesWithNull:List<String?> = listOf("Unicon") + listOf(null) + languages

private suspend fun getProgrammingLanguages(): Flow<String> = flow {
    languagesWithNull.forEach {
        if(it == null) throw IllegalStateException()
        delay(1000)
        emit(it)
    }
}

// When we collect the flow, as soon as the exception is encountered, the program
// terminates
//private fun main() = runBlocking {
//    getProgrammingLanguages()
//        .collect { println(it) }
//}

// By calling catch() before collecting the flow, we can catch the exception in a
// single place, and prevent the app from crashing
private fun main() = runBlocking {
    getProgrammingLanguages()
        .catch { error -> emit("") }
        .collect { println(it) }
}

// This approach has the drawback of terminating the flow however

// To prevent the flow from completing in response to an error, we should try to
// avoid throwing an exception in the first place

//private suspend fun getProgrammingLanguages(): Flow<String> = flow {
//    languagesWithNull.forEach {
//        delay(1000)
//        if(it != null) emit(it)
//    }
//}