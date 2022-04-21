package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

// Like Collections and Sequences, Flows have many functions that may
// be applied to them to transform the elements being collected

// Here, we are filtering out all elements less then length 4, and then
// taking only the first 3 that pass the length filter
private fun main(): Unit = runBlocking {
    getProgrammingLanguages()
        .filter { language -> language.length >= 4 }
        .take(3)
        .collect { println(it) }
}

private suspend fun getProgrammingLanguages(): Flow<String> = flow {
    languages.forEach {
        delay(1000)
        emit(it)
    }
}