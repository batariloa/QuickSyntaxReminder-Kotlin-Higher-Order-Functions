import kotlin.concurrent.thread

fun main() {

    val addition = doAddition()
   println(addition(2,3))


    rollDice { println(it) }

    rollDice() //null
    }


fun addNumbers(x:Int,y:Int) = x.plus(y)

fun doAddition():(Int,Int) ->Int{

    return ::addNumbers
}

fun rollDice(callback: ((result:Int) -> Unit)?=null ):String{

    thread{
        Thread.sleep(3000)
        callback?.invoke((1..6).random())
    }

    return "Dice rolled. Running different thread."
}