package variance

/**
 * covariant (out) = outgoing may narrow the possible values
 * contravariant (in) = incoming may widen the possible values
 */

/**
 * What if we want a class that needs to be generic in both in and out
 * positions?
 *
 * Here, we can use multiple type parameters and mark in and out as needed
 */

/**
 * We'll create an updated version of our exchange that will specific two
 * generic types.  One for the values coming in, and another for values
 * being returned.
 */
private class ValueExchange<in T : ValueStore, out K : ValueStore> {
    fun send(value: T): Unit = TODO()
    fun receive(): K = TODO()
}

private fun main() {
    var exchange: ValueExchange<USD, STOCK> = ValueExchange()
    exchange.send(USD())
    val stock = exchange.receive()

    // this new exchange widens in the incoming types, while limiting outgoing
    // so callers can expect consistent behavior
    exchange = ValueExchange<FIAT, APPL>()
}