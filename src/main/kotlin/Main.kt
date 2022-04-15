import kotlin.concurrent.thread

fun main() {

    val addition = doAddition()
    println(addition(2,3))

    //passing a function that prints the result
    rollDice { println(it) }

    //passing a function to function
    val broj = rollDicePassFunction(){ generateNumberForDice() } // store a function call in a variable

    println(broj())  //call the function stored
    }


fun addNumbers(x:Int,y:Int) = x.plus(y)



fun doAddition():(Int,Int) ->Int{

    return ::addNumbers
}


//generate a number from 1 to 6
fun generateNumberForDice():Int { return (1..6).random(); }

//accepts a function without parameters that returns Int 
fun rollDicePassFunction(callback: () -> Int): () -> Int {

    return callback
}

//accepts a function without parameters, that returns nothing. This function is optional.
fun rollDice(callback: ((result:Int) -> Unit)?=null ):String{

    thread{
        Thread.sleep(3000)
        callback?.invoke((1..6).random())
    }

    return "Dice rolled. Running different thread."
}