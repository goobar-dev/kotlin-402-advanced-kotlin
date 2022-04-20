package contracts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

// If we update our function to provide its own contracts, the
// compiler will use that information to improve the smartcast
@OptIn(ExperimentalContracts::class)
private fun String?.isNotNullOrBlank(): Boolean {
    contract {
        returns(true) implies(this@isNotNullOrBlank != null)
    }
    return !isNullOrBlank()
}

// Now that the function has its own contract, we can skip the
// null-safe call
private fun main() {
    val name: String? = "Kotlin"
    if (name.isNotNullOrBlank()) {
        println("name is ${name.length} characters long")
    }
}