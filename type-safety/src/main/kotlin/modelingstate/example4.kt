package modelingstate

import arrow.core.None
import arrow.core.Option
import arrow.core.Some

// The Arrow Core library includes a number of functional data types that
// work well for use cases such as these.

// Here, we've refactored our function to return an `Option` type which
// is designed to represent either the absence of data with `None` or some
// loaded value using `Some`.  This is a great example of moving away from
// `null` to represent the absence of data.
private fun loadUser(name: String): Option<User> = Some(User(name))

// Because `Option` is defined using a sealed class, we get the nice benefits
// of `when` statements/expressions helping us handle each case
private fun main() {
    when(val result = loadUser("Nate")) {
        None -> println("No user exists")
        is Some -> println("User's name was ${result.value}")
    }
}