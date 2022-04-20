package contracts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

// To improve the compiler's ability to perform smartcasting, we
// can leverage Kotlin's Contract apis

// A contract gives additional information to the compiler that
// it can use to improve its smartcasts

// Here, we've updated our previous example
// We've added a contract that indicates that a return of `false` means
// the receiver is not null.
@OptIn(ExperimentalContracts::class)
private fun Any?.isNull(): Boolean {
    contract {
        returns(false) implies (this@isNull != null)
    }
    return this == null
}

// With our function updated to use a contract, the compiler can now
// perform a smartcast on the name variable after our conditional check
private fun main() {
    val name: String? = "Kotlin"
    if (name.isNull()) return

    println("name is ${name.length} characters long")
}
