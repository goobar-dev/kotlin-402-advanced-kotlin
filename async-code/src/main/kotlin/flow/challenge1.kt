package flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

/**
 * Use the flowOf() function to generate a Flow to print the following values
 *
 * Kotlin
 * Java
 * C++
 * Dart
 * Go
 *
 */
private fun getProgrammingLanguages(): Flow<String> = flowOf("Kotlin", "Java", "C++", "Dart", "Go")

private fun main() = runBlocking {
    getProgrammingLanguages().collect { println(it) }
}