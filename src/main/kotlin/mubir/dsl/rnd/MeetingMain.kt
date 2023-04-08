package mubir.dsl.rnd

class Meeting{
    val start = this

    // eita kind of logic
    fun at(range:IntRange)
    {
        println(" at $range")
    }
}

fun String.meeting(lambda:Meeting.()->Unit) {
    // eita kind of doorway mane liking call with class
   Meeting().lambda()
}

fun main(arg:Array<String>)
{
    // eita kind of calling .
    "planning".meeting {
        this.at(3..12)
    }
}