import kotlin.random.Random

class Circle(val radius: Double)
    : Shape("Circle") {
        // create singleton function, access via static
        companion object {
            fun createRandomCircle(): Circle  = Circle(Random.nextDouble(1.0, 10.0))
        }
        init{
            println("$name is lingin")
        }
    override fun getPerimeter(): Int = (radius.times(ImportantNumbers.PI)).toInt()

    override fun getArea(): Int  = (ImportantNumbers.PI.times(radius).times(2)).toInt()
}