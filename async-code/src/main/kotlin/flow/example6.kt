package flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.random.Random

private class StateFlowLocationManager : LocationProvider {

    private val scope = CoroutineScope(Dispatchers.IO)

    private val _lastLocation: MutableStateFlow<Location?> = MutableStateFlow(null)
    override val lastLocation: StateFlow<Location?> = _lastLocation

    init {
        scope.launch {
            while(true) {
                delay(1000)
                _lastLocation.emit(Location(Random.nextFloat(), Random.nextFloat()))
            }
        }
    }
}

// Because the StateFlow broadcasts the most recent value to new collectors, both
// calls to first() here produce the same value

fun main() = runBlocking {
    val manager = StateFlowLocationManager()
    delay(3000)
    val firstObserver = manager.lastLocation.first()
    val secondObserver = manager.lastLocation.first()

    println(firstObserver == secondObserver)
}
