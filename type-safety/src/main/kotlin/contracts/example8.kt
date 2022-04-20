package contracts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

// We can define a contract the tells the compiler how often to
// expect a function parameter to be called.  In this case, we
// specify that the passed function will be called exactly one time
@OptIn(ExperimentalContracts::class)
private fun State.setup(config: State.() -> Unit) {
    contract { callsInPlace(config, InvocationKind.EXACTLY_ONCE) }
    config()
}

// With the expectation of the lambda being called exactly once,
// the compiler will now allow the initialization of `screenTitle`
// within the lambda
private fun main() {
    val state: State = State.Success("Hello Kotlin!")
    val screenTitle: String

    state.setup {
        screenTitle = if(this is State.Success) msg else ""
    }

    println(screenTitle)
}