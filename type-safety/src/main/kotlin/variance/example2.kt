package variance

// In this example, we don't see the same behavior
// List<Number> is assignable to List<Number>
// But, List<Float> is also assignable to List<Number>
private fun main() {
    var list: List<Number> = listOf<Number>()
    list = listOf<Float>()
}

// The answer here is that List is covariant in the type parameter T
// This means that the type T only occurs in the "out" position
// In this case, it means List<T> will produce Ts, but not consume them

// Notice however that this doesn't work the same way for MutableList<T>
// MutableList is invariant in its type parameter
// The type T occurs both in the "in" and "out" position, and therefore
// we are required to explicitly use the same type in assignment
//private fun main() {
//    var list: MutableList<Number> = mutableListOf<Number>()
//    list = mutableListOf<Float>() // not allowed
//}