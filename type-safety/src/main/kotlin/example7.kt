
// Here, we've defined an extension function for helping us
// using a given `State` instance to initialize other variables
// in the application
private fun State.setup(config: State.() -> Unit) {
    config()
}

// In this example, we'd like to initialize `screenTitle` within `setup()`
// However, we cannot.  The val can only be initialized once, and `setup()`
// provides no guarantees around how many times the passed lambda will be
// called
private fun main() {
    val state: State = State.Success("Hello Kotlin!")
    val screenTitle: String

    state.setup {
        //screenTitle = if(this is State.Success) msg else ""
    }

    //println(screenTitle)
}