package mubir.dsl.rnd

fun main(args:Array<String>)
{
    val obj = TemplateClass()

    obj.email = "ola@gmail.com"
    obj.name = "myname"
    obj.phone = "1233"

    obj.notFun
}
val TemplateClass.notFun get() = println("name: ${this.name}")