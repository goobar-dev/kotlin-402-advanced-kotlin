package contracts

// You likely have already been using contracts without realizing it
// Within the Kotlin Standard Library, contracts are already being
// used to provide additional info to the compiler.

// Examine the `isNullOrBlank` function
// A return of `false` implies that the receiver value must not be null

// Contracts do not propagate between callstacks.
// If we implement `isNotNullOrBlank` as the negation of `isNullOrBlank`
// the contract will not be applied/negated for the new method
private fun String?.isNotNullOrBlank() = !isNullOrBlank()

// Even though our new function relies on a function with a contract
// we must still use a null-safe call when accessing the name variable
private fun main() {
    val name: String? = "Kotlin"
    if (name.isNotNullOrBlank()) {
        println("name is ${name?.length} characters long")
    }
}