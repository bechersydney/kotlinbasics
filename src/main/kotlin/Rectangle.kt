class Rectangle(val width: Int, val height: Int) : Shape("Parent") {
    init {
        println("$name the width is $width")
        println("the height is $height")
    }

    fun getArea():Int = width * height
    fun isSquare():Boolean = width == height
    fun perimeter():Int = (height.times(2)) + (width.times(2))
    override fun changeName(newName:String){
        println(newName)
        name = newName
    }

}