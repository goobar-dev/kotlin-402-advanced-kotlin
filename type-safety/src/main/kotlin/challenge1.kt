
private sealed class NetworkRequestResult<T> {
    class Loading<T>: NetworkRequestResult<T>()
    data class Success<T>(val data: T): NetworkRequestResult<T>()
    data class Error<T>(val error: Throwable): NetworkRequestResult<T>()
}


private fun <T> NetworkRequestResult<T>.isSuccess(): Boolean {
    return if (this is NetworkRequestResult.Success) true else throw IllegalStateException()
}

// Add a contract to `isSuccess()` so we don't have to manually cast
// `result` before accessing the `data` property
private fun main() {
    val result = getNetworkResult<String>()

    if (result.isSuccess()) println((result as NetworkRequestResult.Success<String>).data)
}

private fun <T> getNetworkResult() = NetworkRequestResult.Loading<T>()