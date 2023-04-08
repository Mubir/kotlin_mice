package mubir.dsl.rnd

import java.time.LocalDate

val ago="ago"
val from_now="from now"
infix fun Int.days(tense:String){
    when(tense) {
        ago -> println(LocalDate.now().minusDays(this.toLong()))
        from_now ->println(LocalDate.now().plusDays(this.toLong()))
    }

}
fun main(args:Array<String>)
{
    println("•••••••••• days Dsl ••••••••••")
//    without infix
//    2.days(ago)
    2 days ago
}