package variance

/**
 * Let's create an Exchange class that we want to use to
 * exchange one ValueStore for another
 *
 * So, we define a generic value parameter extending ValueStore
 */
private class Exchange<T : ValueStore>

/**
 * We can assign an instance of Exchange<FIAT> to our Exchange<FIAT> variable
 */
//private fun main() {
//    val exchange: Exchange<FIAT> = Exchange()
//}


/**
 * Now, what if we wanted the ability to assign a more specific type to
 * our variable?
 *
 * We could make Exchange covariant in its type parameter
 * This would make Exchange only a producer of T rather than producer and consumer
 *
 * Because T is specified as only occurring in the out position, and USD is a subtype of
 * FIAT, the assignment is allowed. Anything expecting to handle FIAT will be able to
 * handle USD
 */
//private class Exchange<out T : ValueStore>
//private fun main() {
//    val exchange: Exchange<FIAT> = Exchange<USD>()
//}