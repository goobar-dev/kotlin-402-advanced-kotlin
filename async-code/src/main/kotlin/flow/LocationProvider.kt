package flow

import kotlinx.coroutines.flow.Flow

interface LocationProvider {
    val lastLocation: Flow<Location?>
}