
// Imagine we have a helper function that directly, or indirectly,
// should allow the compiler to infer whether or not a value is null
private fun Any?.isNull() = this == null

// Ideally, when using a function like this, the Kotlin compiler would be able
// to understand whether something is null or not, and smartcast the value for us

// In this example however, even though we can intuitively understand the code is
// safe, the compiler cannot.  And so, we must then use a null-safe call, or other
// means of handling the possibly null `name` variable
private fun main() {
    val name: String? = "Kotlin"
    if (name.isNull()) return

    println("name is ${name?.length} characters long")
}