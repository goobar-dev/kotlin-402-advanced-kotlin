import java.lang.IllegalStateException

// Imagine we have some sealed set of state types
sealed class State {
    object Loading: State()
    data class Success(val msg: String): State()
    object Error: State()
}

// We want to define a function that performs a runtime check
// to ensure the current State is Success.
// Ideally, if the function returns true, the compiler should
// understand that the State value is an instance of Success
// and automatically smartcast it as such so we can access properties
// specific to Success
private fun State?.requireSuccess(): Boolean {
    return if(this is State.Success) true else throw IllegalStateException()
}

// However, here the compiler cannot infer this information as is
// We must manually cast `state` to `State.Success` to access `msg`
private fun main() {
    val state: State? = State.Success("success!")

    if(!state.requireSuccess()) return

    println((state as State.Success).msg)
}