package flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.random.Random

// If we want to broadcast values to multiple collectors at the same time, we
// can used SharedFlow.  We can customized SharedFlow to include replay

private class SharedFlowLocationManager : LocationProvider {

    private val scope = CoroutineScope(Dispatchers.IO)

    private val _lastLocation: MutableSharedFlow<Location?> = MutableSharedFlow()
    override val lastLocation: SharedFlow<Location?> = _lastLocation

    init {
        scope.launch {
            while(true) {
                delay(1000)
                _lastLocation.emit(Location(Random.nextFloat(), Random.nextFloat()))
            }
        }
    }
}

// Both collections of the lastLocation Flow will receive the same first 5 values
// This is due to SharedFlow's support for multicasting

fun main() = runBlocking {
    val manager = SharedFlowLocationManager()
    delay(2000)

    val task1 = async {
        manager.lastLocation.take(5).collect { println("1) $it") }
    }

    val task2 = async {
        manager.lastLocation.take(6).collect { println("2) $it") }
    }

    joinAll(task1, task2)
}