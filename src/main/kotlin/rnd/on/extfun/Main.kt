package rnd.on.extfun

fun main(args: Array<String>) {
    var objInc = Innocent()

    println(objInc.whoAmI())

    fun Innocent.extMe(): String {
        return "u made me "
    }

    println("ext no prams: ${objInc.extMe()}")

    fun Innocent.giveMeUrSeed(seed: String): String {
        return "It's ur $seed"
    }

    println("seed: ${objInc.giveMeUrSeed("J@rvis")}")

    fun Innocent.worldUpSideDown(dsl: () -> List<String>): List<String> {
        return dsl()
    }

    println(" ${objInc.worldUpSideDown { "omg r u woking".split(" ") }}")

    fun Innocent.ohNo(dsl: () -> List<String>) {
        dsl().forEach { wtf ->
            print("$wtf, ")
        }
    }

    println(" ${objInc.ohNo { "oh no what is happening".split(" ") }}")

    fun Innocent.wakaranai(dsl: (plzwork: Innocent) -> List<String>) {
        dsl(this).forEach { wtf ->
            print("$wtf+")
        }
    }

    println(" ${objInc.wakaranai { opps: Innocent -> opps.whoAmI().split(".") }}")
}