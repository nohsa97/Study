package com.example.myapplicationd

open class Human (val name : String = "noval"){

    constructor(name:String,age:Int) : this(name){

    }

    init {
        println("start")
    }

    open fun eat (){
        println("eat")
    }
}

val sqr = {num:Int -> num*num}

val addstr : String.(Int) -> String = {
    this + "ADDed" + it}

val cal : (Int) -> Unit= {
    when(it) {
        in 1..10 -> println("fuck")
        else -> println("no")
    }
}

class nohumna :Human (){
    override fun eat() {
        println("no eat")
    }
}

fun main() {
    val human = Human("minsu")
    val no = nohumna()
    val ss = "noADD "

    human.eat()
    no.eat()

    print(sqr(12))
    println(ss.addstr(30))
    cal(1000)

}

