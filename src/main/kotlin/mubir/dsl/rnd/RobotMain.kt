package mubir.dsl.rnd

class Robot{
    val left = "left"
    val right = "right"

    fun turn(direction:String)
    {
        println("go.. $direction")
    }
}

fun operate(lambda:(Robot)->Unit){
    lambda(Robot())
}

fun main(arg:Array<String>)
{
    operate {
        it.turn("left")
    }
}