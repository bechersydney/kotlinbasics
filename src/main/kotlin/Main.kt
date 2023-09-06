const val nameVal = "private static final String in java";

fun main(args: Array<String>) {
    val name = "Sydney Becher"
    println("Hello $name!")
    val exampleNumber = 1200000.00
    println(exampleNumber.toInt())
    println(sum(1, 2))
    val a = 3
    val b = 9
    println("sum of a and b = ${a + b}")
    println(a.minus(3))
    ifElse()
    funcParams("sydney")
    defaultNamedParams(
        message = "Hello",
        name="Sydney"
    )

    // spread and varargs and name params
    val array = intArrayOf(1, 2, 3, 4, 5, 6)

    println(spreadVarArgs(10, 20, *array, 20, 30, b = 40))

    // classes
    val user1 = User("   Hans   ", 30)
    val user2 = User("  Elfriede   ", 60)
    val user3 = User(age = 60)
    val user4 = User("    ", 20)

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

fun funcParams(name:String){
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
fun funOverload(a: Int, b: Int) = if (a > b) a else b

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