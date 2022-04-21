package dev.goobar

import dev.goobar.data.Joke
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

object JokeGenerator {
    private val jokes = listOf(
        Joke(
            setup = "What’s more amazing than a talking dog?",
            punchline = "A spelling bee."
        ),
        Joke(
            setup = "I'm reading a book about anti-gravity.",
            punchline = "I can't put it down."
        ),
        Joke(
            setup = "I didn't like my beard at first.",
            punchline = "Then it grew on me."
        ),

    )

    suspend fun getJoke() = withContext(Dispatchers.IO) {
        delay(2000)
        jokes.random()
    }
}