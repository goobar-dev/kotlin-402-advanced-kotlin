package modelingstate

import arrow.core.Either

// Sometimes, we may expect a certain type of error
// Traditionally, we may have wrapped that in a try/catch at the call site
// Arrow Core provides a useful `Either` type that we can use in cases like
// this.

// `Either` lets us model some result that might be either TypeA or TypeB

// In this case, we will return an exception, or a valid `User`
private fun loadUser(name: String): Either<IllegalStateException, User> {
    return if (name.isEmpty()) {
        Either.Left(IllegalStateException("name parameter must not be empty"))
    } else {
        Either.Right(User(name))
    }
}

// And again, we can take advantage of when to handle each case
private fun main() {
    when(val result = loadUser("Nate")) {
        is Either.Left -> println(result.value)
        is Either.Right -> println("User's name was ${result.value}")
    }

    // `Either` provides numerous functions for transforming/handling
    // the possible types
    val result = loadUser("")
    result.fold(
        ifLeft = { error ->
            println(error)
        },
        ifRight = { user ->
            println("User's name was ${user.name}")
        }
    )
}