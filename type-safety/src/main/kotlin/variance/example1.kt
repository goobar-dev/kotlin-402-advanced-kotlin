package variance

// Imagine we're creating some custom container which we want
// to be able to hold any value type.
//
// We might leverage a generic type here to support this
private class CustomContainer<T>

// Container<Number> is assignable to Container<Number>
// However, Container<Float> is not assignable to Container<Number>
// even though Float is a subtype of Number
fun main() {
    var container: CustomContainer<Number> = CustomContainer<Number>()
//    container = CustomContainer<Float>() // not allowed
}