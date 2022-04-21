package modelingstate

// Modeling function results, or elements from an observable stream, as
// some kind of "result" type, or other type container can improve the
// safety and completness of our error handling

// Here, we've refactored our function to use Kotlin's `Result` type
private fun loadUser(name: String): Result<User> = Result.success(User(name))

// Now, we can inspect the result to check if it's "successful" or a "failure"
// We can encourage the handling of both cases by using the `fold()` function
// and providing behavior for both
private fun main() {
    val userResult = loadUser("Nate")

    userResult.fold(
        onSuccess = { user ->
            println("User's name was ${user.name}")
        },
        onFailure = { error ->
            println("Failed to load user: ${error.message}")
        }
    )

    userResult.isSuccess // check if result is successful
    userResult.isFailure // check if result is a failure
    userResult.onFailure {  } // handle just the failure
    userResult.onSuccess {  } // handle just the success
}