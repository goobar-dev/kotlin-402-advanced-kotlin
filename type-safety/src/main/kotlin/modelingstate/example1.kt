package modelingstate

// It's not uncommon to define methods like this which rely on
// null to signify a failure, or a lack of data
private fun loadUser(name: String): User? = User(name)

// When we rely on null however, we introduce several potential issues

// We have to address the possible NullPointerException
// We have to remember to handle the failure or error state
// We lose precision if we need more than 2 states
private fun main() {
    val user = loadUser("Nate")

    if (user != null) {
        println("User's name was ${user.name}")
    }
}