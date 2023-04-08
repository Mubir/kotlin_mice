package mubir.godeep.funreceiver

fun main(args: Array<String>) {
    println("****")
    saySomething("heisenberg")
    betterCall("Saul goodman") {
        println("better call saul")
    }
    callMeAnyway({ print("mike,") })
    callMeAnyway() {
        print("pinkman")
    }
    callMeAnyway {
        println(":: hey ,bi**")
    }

    println("«««««««««««««««««««««««« Ext fun »»»»»»»»»»»»»»»»»»»»»»»")
    val obj = Psychedelic()
    obj.show()

    iAmTakingLambda {
        println("OMA!! I got called")
    }

    extAsParams {
        println("ext as Params::  its getting funny.*****")
    }
    extAsParams {
        // as context is type "Psychedelic" amara ei class er sob var + fun call or acccess korte porbo
        itemOne = "i have access to you"
        this.prnt()
    }

    extAsParamsWhewLambdaTakesParams("Nachos") { name ->
        println(name.toUpperCase())
    
    }

}

/**
 *  basic syntax:
 *     val name_of_lambda: ()->Return_type(eg:Unit..Int) = { // write ur code}
 * */

// lambda.1
val saySomething: (name: String) -> Unit = { name ->
    println("say my name. $name")
}

// lambda.2
val betterCall: (name: String, lambda: () -> Unit) -> Unit = { name, lambda ->
    println("i am $name ")
    // lamda ekta function so eke call korte hobe as a function,kali pass korle hobe na 'lambda' kaj korbe na.
    lambda()

}

// lambda :: with different way of calling
val callMeAnyway: (lambda: () -> Unit) -> Unit = { lambda ->
    lambda()
}

/**
 *  ext fun
 * */

val show: Psychedelic.() -> Unit = {
    this.itemOne = "Opps"
    println("$itemOne")
}

// function with lambda
fun iAmTakingLambda(lambda: () -> Unit) {
    lambda()
}

// pass lambda ext fun to a funcion parms
fun extAsParams(lambda: Psychedelic.() -> Unit) {
    // context is type Psychedelic here so need to create obj & then call obl.lambda()
    // only lambda() do not work.

    Psychedelic().lambda()
}

// pass lambda ext fun to a funcion parms
fun extAsParamsWhewLambdaTakesParams(name: String, lambda: Psychedelic.(String) -> Unit) {
    // context is type Psychedelic here so need to create obj & then call obl.lambda()
    // only lambda() do not work.

    Psychedelic().lambda(name)
}