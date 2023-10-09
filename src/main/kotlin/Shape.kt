open class Shape(var name:String){
    init {
        println("The name is $name")
    }
    fun isParent():Boolean = true
    open fun changeName(newName: String){
        name = newName
    }
}