import java.lang.Exception
import java.util.concurrent.RecursiveAction

const val nameVal = "private static final String in java";

fun main(args: Array<String>) {
//    val name = "Sydney Becher"
//    println("Hello $name!")
//    val exampleNumber = 1200000.00
//    println(exampleNumber.toInt())
//    println(sum(1, 2))
//    val a = 3
//    val b = 9
//    println("sum of a and b = ${a + b}")
//    println(a.minus(3))
//    ifElse()
//    funcParams("sydney")
//    defaultNamedParams(
//        message = "Hello",
//        name = "Sydney"
//    )
//    val user5 = User(name = "Kamote", age = 24)
//    // spread and varargs and name params
//    val array = intArrayOf(1, 2, 3, 4, 5, 6)
//
//    println(spreadVarArgs(10, 20, *array, 20, 30, b = 40))
//
//    // classes
//    val user1 = User("   Hans   ", 30)
//    val user2 = User("  Elfriede   ", 60)
//    val user3 = User(age = 60)
//    val user4 = User("    ", 20)
//    println("Please enter your age:")
//    val userInput = readln()
//    if (userInput.isNullOrEmpty()) return
//    val age = userInput.toInt()
//    val message = when(age) {
//        in 1..20 -> "You are a boy"
//        in 21..60 -> "You are men enough"
//        100, 101 -> "You are extra ordinary"
//        else -> "You are Legend!"
//    }
//    println(message)
    val arr = arrayOf("hello", "guys", "how", "are you?")
    for (i in 1..<arr.size) {
        println("${arr[i]} -> with index $i")
    }
//    println(arr.joinToString())
//    var x = 5
//    while (x != 0) {
//        println("$x count")
//        x--
//    }
//    for (i in 1..10 step 2) {
//        println(i)
//    }
    val mayArr = arrayOf(1, 2, 3)
//    println(mayArr.max() )
//    var sum = 0
//    for (i in mayArr) {
//        sum += i
//    }
//    println(sum)
//    // get average
//    var average = 0.0
//    for(i in 1..5) {
//        val userInput = readln().toInt()
//       average += (userInput / 5.0)
//    }
//    println("$average")
//    println("Please enter your country?")
//    val userInput = readln()
//    var greet = when(userInput) {
//        "Philippines" -> "Mabuhay"
//        "USA" -> "long live"
//        "India" -> "Mekus mekus na yan"
//        else -> "Tanga ka!"
//    }
//    println(greet)
//
//    var sampleList = mutableListOf(1,2,3,4,5)
//    println(sampleList.reversed())

//    println("Please input a number to check if it is prime:")
//    val userInput = readln()?.toInt()
//    val isPrime = if (userInput != null && userInput.isPrime()) {
//        "prime"
//    } else {
//        "even"
//    }
//    println("$userInput is $isPrime")
//
//    val myArr = listOf(1,2,3,4,5,6)
//    println(myArr.getProduct())

    // inheritance and overloading
//    val rectangle = Rectangle(width = 20, height = 30)
//    println(rectangle.isSquare())
//    println(rectangle.getPerimeter())
//    println(rectangle.getArea())
//
//    val rectangle2 = Rectangle(2, 2.1)
//    rectangle2.getPerimeter()
//    val circle = Circle(3.0)
//    println(circle.getPerimeter())
//    println(circle.getArea())
    // singleton function and object (companion and object)
    val circle = Circle.createRandomCircle()
    println("Companion function ${circle.getPerimeter()}")
    // anonymous functions
    // we have to do this because this is abstract
    val a = 3.0;
    val b = 4.0;
    val height = 2.0
    val parallelogram = object : Shape("Parallelogram", a, b, height) {
        init {
            println("$name is created")
        }
        override fun getPerimeter(): Int = a.times(b).times(height).toInt()
        override fun getArea(): Int = (a.times(b).times(height)).times(2).toInt()
    }
    println("The parallelogram perimeter is ${parallelogram.getPerimeter()}")
    println("The parallelogram area is ${parallelogram.getArea()}")
    // Exception

    tryCatch()
    println(divide(5.0, 1.0))
    lambDa(){
        println("The callback is $it")
    }

    var listInt = listOf(1,2,3,4,5)
    listInt = listInt.customFilter { it > 3 }
    println(listInt)

    val circle1 = Circle(1.0)
    val circle2 = Circle(10.0)
    val rect = Rectangle(23)
    val rect1 = Rectangle(12.0)
    val listOfShape = listOf(circle, circle1, circle2, rect, rect1)
    val transformedList = listOfShape.customFilter{shape -> shape.getArea() > 2}

    var intList = (1..10).toList()
    val sum = intList.getOddSum { it % 2 == 1 }
    println(sum)
    for(shape in transformedList){
        println(shape.name)
    }

    // Custom Generic
    var customGeneric = CustomGeneric<String ,Int ,Shape, Shape>("Hello", 1, circle, rect1)
    customGeneric.printTypes()
}

// function extension

//fun List<Shape>.customFilter(func: (Shape, String)-> Boolean): List<Shape>{
//    val shapeList = mutableListOf<Shape>()
//    for(shape in this) {
//        if(func(shape, shape.name)){
//            shapeList.add(shape)
//        }
//    }
//    return shapeList
//}

// generic equivalent on top
fun <T> List<T>.customFilter(func: (T)->Boolean):List<T> {
    var resultList = mutableListOf<T>()
    for(item in this) {
        if(func(item)){
            resultList.add(item)
        }
    }
    return resultList
}

fun List<Int>.getOddSum(func: (Int) -> Boolean): Int {
    var sum = 0
    for(i in this) {
        if(func(i)){
            sum +=  i
        }
    }
    return sum
}
fun List<Int>.getProduct(): Int {
    var product = this[0]
    for (i in 1..<this.size) {
        product *= this[i]
    }
    return product
}
// same functionality of .filter
//fun List<Int>.customFilter(customFilterFunction: (Int)-> (Boolean)): List<Int> {
//    val resultList = mutableListOf<Int>()
//    for(i in this) {
//        if(customFilterFunction(i)){
//            resultList.add(i)
//        }
//    }
//    return resultList
//}

fun Int.isPrime(): Boolean {
    for (i in 2..<this) {
        if (this % i == 0) {
            return false
        }
    }
    return true
}

fun helloWorld() {
    println("Hello Kotlin")
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun ranges() {
    //for (i in 1..10) println(i)

    //for (i in 1 until 10) println(i)

    //for (i in 10L downTo 1) println(i)

    //for (i in 'a'..'z' step 2) println(i)
}

fun arrays() {
    val names = arrayOf("sydn", "bech", "kato", "tets")
    for (i in names.indices) {
        println("index $i : element: ${names[i]}")
    }
    // get the last element
    println(names.last())
    // get size
    println(names.size)

    //for (name in names) println(name)


    names[0] = "Jeremy"
    println("Number of elements: ${names.size}")
    println("First element: ${names[0]}")
    println("Last element: ${names[2]}")
}

fun operators() {
    println("2 > 1 is ${2 > 1}")
    println("2 < 1 is ${2 < 1}")
    println("1 >= 1 is ${1 >= 1}")

    println("1 == 1 is ${1 == 1}")
    println("1 == 2 is ${1 == 2}")
    println("1 != 2 is ${1 != 2}")

    println("!(2 > 1) is ${!(2 > 1)}")

    println("true && false = ${true && false}")
    println("true || false = ${true || false}")

    // `or` and `and` and `xor` is used to evaluate all expression even the first is meet/true already

    val condition = (2 > 1) || (3 > 2) && (2 > 3)
    println(condition)
}

fun loops() {
    var i = 0

    outer@ do {
        println(i)
        i++
        //continue

        var j = 0

        while (j < 5) {
            println("---$j")
            j++
            break@outer //break the outer loop as well
            println("I'm not printed")
        }

        println("I'm printed")

    } while (i < 5)

    var number = 8

}

// this is the ternary in kotlin
fun ifElse() {
    for (i in 1..100) {
        val pref = when (i) {
            1 -> "I am one"
            in 2..99 -> {
                println("I am in $i")
                "Kamtoe"
            }

            else -> "I am here"
        }
    }
    for (i in 1..10) {

        val prefix = if (i == 1) {
            "*"
        } else if (i !in 4..7) {
            "-"
        } else {
            print("-")
            ">"
        }

        println("$prefix $i")
    }

    val time = 2
    val greetings = if (time in 1..11) {
        "Good morning"
    } else if (time == 12) {
        "good afternoon"
    } else {
        "Good day!"
    }
    println(greetings)
}

fun switchInJava() {
    val time = 14
    val isSunday = true
    val greeting = when (time) {
        1 -> "I'm gonna stay in bed all day!"
        5 -> "Why up so early?"
        in 1..11 -> "Good morning!"
        12 -> "Time for lunch!"
        13, 14 -> {
            println("Yawn...")
            "Time for a nap!"
        }

        else -> "Good day!"
    }

//    val greeting = when {
//        isSunday -> "I'm gonna stay in bed all day!"
//        time < 5 -> "Why up so early?"
//        time in 0..11 -> "Good morning!"
//        time == 12 -> "Time for lunch!"
//        time == 13 || time == 14 -> {
//            println("Yawn...")
//            "Time for a nap!"
//        }
//        else -> "Good day!"
//    }

    println(greeting)
}

fun funcParams(name: String) {
    println("Hello $name")
}

fun greet(name: String, reps: Int) {
    var repsLeft = reps

    while (repsLeft > 0) {
        println("Hello, $name! Nice to meet you!")
        repsLeft--
    }
}

// single expression function, this is like in javascript
// const double = (num) => num * 2
fun singleExp(num: Int) = num * 2

// is equivalent to
fun singleExpEquivalent(num: Int): Int {
    return num * 2
}

// function overloading
fun funOverload(a: Int, b: Int) = if (a >  b) a else b

fun funOverload(a: Double, b: Double) = if (a > b) a else b

fun funOverload(a: Int, b: Int, c: Int) =
    when {
        a >= b && a >= c -> a
        b >= a && b >= c -> b
        else -> c
    }

// default and named parameter
fun defaultNamedParams(message: String, name: String = "User", reps: Int = 1) {
    for (i in 0 until reps) println("Hello, $name! $message")
}

// spread and varargs
fun spreadVarArgs(a: Int, vararg numbers: Int, b: Int): Int {
    var sum = a + b

    for (number in numbers) sum += number

    return sum
}


fun spreadVarArgs1(first: Int, vararg remaining: Int): Int {
    println(nameVal)

    var max = first

    for (i in remaining) {
        if (i > max) max = i
    }

    return max
}

fun isPrimeNumber(a: Int): Boolean = a % 2 == 0

fun gradeRatingConversion(rating: String): Int {
    val ratingEquivalent = when (rating) {
        "A" -> 99
        "B" -> {
            println("You are almost there")
            return 95
        }

        else -> 65
    }
    return ratingEquivalent
}

fun doubleANumber(a: Int): Int = a * 2


// Exception
// Custom Exception
class DivideByZeroException : Exception("divisor cannot be zero")

fun tryCatch() {
//    println("Please Enter a number: ")
//    val input = try{
//        readln()?.toInt()
//    }catch (e: Exception) {
//        0
//    }finally {
//        println("Finally executed!")
//    }
//    println("Exception entered $input")
    val quotient = try {
        divide(3.0, 0.0)
    }catch (e: DivideByZeroException){
        0
    }
    println("Output is $quotient")
}

fun divide(a: Double, b: Double): Double {
    if(b == 0.0) throw DivideByZeroException()
    return a / b
}

// lambda (mostly used in callback and array methods(map, filter))
fun lambDa(callback: (Int)-> Unit) {
    var list = (1..20).toList()
    list.map {
        println(it)
    }
    callback(list[0])
}



// classes
class User(name: String = "No Name", var age: Int) {
    init {
        print("New user created. Age: $age,")
    }

    val name: String

    init {
        if (name.isBlank()) {
            this.name = "No Name"
        } else {
            this.name = name.trim()
        }

        println(" Name: ${this.name}")
    }
}