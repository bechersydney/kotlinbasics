fun main(args: Array<String>) {
    val name = "Sydney Becher"
    println("Hello $name!")
    val exampleNumber = 1200000.00
    println(exampleNumber.toInt())
    println(sum(1,2))
    val a = 3
    val b = 9
    println("sum of a and b = ${a +b }")
    println(a.minus(3))
    ifElse()

}

fun helloWorld(){
    println("Hello Kotlin")
}

fun sum(a: Int , b:Int):Int{
    return a + b
}

fun ranges(){
    //for (i in 1..10) println(i)

    //for (i in 1 until 10) println(i)

    //for (i in 10L downTo 1) println(i)

    //for (i in 'a'..'z' step 2) println(i)
}
fun arrays(){
    val names = arrayOf("sydn","bech","kato","tets")
    for(i in names.indices){
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

fun operators(){
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

fun loops(){
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
fun ifElse(){
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
    val greetings = if(time in 1..11){
        "Good morning"
    } else if(time ==12){
        "good afternoon"
    }else{
        "Good day!"
    }
    println(greetings)
}

fun switchInJava(){
    val time = 14
    val isSunday = true

    val greeting = when {
        isSunday -> "I'm gonna stay in bed all day!"
        time < 5 -> "Why up so early?"
        time in 0..11 -> "Good morning!"
        time == 12 -> "Time for lunch!"
        time == 13 || time == 14 -> {
            println("Yawn...")
            "Time for a nap!"
        }
        else -> "Good day!"
    }

    println(greeting)
}
