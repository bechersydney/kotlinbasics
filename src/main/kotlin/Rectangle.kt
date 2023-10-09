class Rectangle(val width: Int, val height: Int) : Shape("Parent") {
    // constructor overloading
    constructor(a: Double): this(a.toInt(), a.toInt())
    init {
        println("$name the width is $width")
        println("the height is $height")
    }
    constructor(a: Int): this(a, a)
    constructor(a:Int, b:Double): this(a, b.toInt())


    override fun getArea():Int = width * height
    fun isSquare():Boolean = width == height
     override fun getPerimeter():Int = (height.times(2)) + (width.times(2))
     override fun changeName(newName:String){
        println(newName)
        name = newName
    }

}