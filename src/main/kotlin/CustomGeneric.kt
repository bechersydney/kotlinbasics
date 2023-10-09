class CustomGeneric<A: Any, B: Any, C: Any, D: Any>(
    var first: A,
    var second: B,
    var third: C,
    var fourth: D
) {
    fun printTypes() {
        println("The type is ${first::class}")
        println("The type is ${second::class}")
        println("The type is ${third::class}")
        println("The type is ${fourth::class}")
    }
}