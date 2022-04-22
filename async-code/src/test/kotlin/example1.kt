import app.cash.turbine.test
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

private suspend fun getNumberOfUsers(): Int {
    delay(3000)
    return Random.nextInt(10)
}

private class NumberGenerator {
    val numbers = flow {
        for (i in 0..3) {
            emit(i)
        }
    }
}


class TestExample1 {

    @Test
    fun `test a suspending function`() = runBlocking {
        val result = getNumberOfUsers()

        assert(result <= 10)
    }

    @Test
    fun `test a suspending function without delay`() = runTest {
        val result = getNumberOfUsers()

        assert(result <= 10)
    }

    @Test
    fun `test a flow while advancing time`() = runTest {
        val collectedValues = mutableListOf<Int>()
        val generator = NumberGenerator()

        generator.numbers
            .take(3)
            .collect { collectedValues.add(it) }

        assert(collectedValues.size == 3)
    }

    @Test
    fun `test a flow with Turbine`() = runTest {
        val generator = NumberGenerator()

        generator.numbers.test {
            assertEquals(0, awaitItem())
            assertEquals(1, awaitItem())
            cancelAndConsumeRemainingEvents()
        }
    }
}