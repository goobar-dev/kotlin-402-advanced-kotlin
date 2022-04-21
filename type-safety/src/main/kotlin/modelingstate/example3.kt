package modelingstate

// We can model our own result types using sealed classes or sealed interfaces
// This can simplify the usage by eliminating generics, or it can allow for
// additional states beyond simply "success" and "failure"
private sealed class UserResult {
    data class Success(val user: User): UserResult()
    data class Error(val error: Throwable): UserResult()
}

private fun loadUser(name: String): UserResult = UserResult.Success(User(name))


// Another benefit to this approach is that the compiler can help enforce
// that every case within a sealed class is handled when using a `when`
// expression.  This is quite helpful to ensure that new states are handled
// in an application.
private fun main() {
    when(val result = loadUser("Nate")) {
        is UserResult.Error -> println("Failed to load user: ${result.error.message}")
        is UserResult.Success -> println("User's name was ${result.user.name}")
    }
}