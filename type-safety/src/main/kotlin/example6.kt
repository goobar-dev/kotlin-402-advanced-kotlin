import java.lang.IllegalStateException
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

// Again, we'll add a contract to our function to help the
// compiler perform smartcasts

// In this example, our contract states that any successful
// return from the function implies that the receive is an
// instance of `State.Success`.

// This is different from the previous examples where we were
// implying conditions around nullability

@OptIn(ExperimentalContracts::class)
private fun State?.requireSuccess(): Boolean {
    contract {
        returns() implies(this@requireSuccess is State.Success)
    }
    return if(this is State.Success) true else throw IllegalStateException()
}

// With the contract in place, we no longer have to manually cast
// `state` to access `msg`
private fun main() {
    val state: State? = State.Success("success!")

    if(!state.requireSuccess()) return

    println(state.msg)
}