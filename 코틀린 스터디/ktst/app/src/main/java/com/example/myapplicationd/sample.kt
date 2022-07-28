package com.example.myapplicationd

fun main () {
    hellowolrd()

    array()
}

fun hellowolrd() :Unit {
    println("hello")
}

fun checkInt(input : Int) :Unit{
    when(input) {
        0 -> print("that 0")
        1 -> print ("that 1")
        in 90..100 -> print("high")
    }
}

fun array(){
    val arry = arrayOf(1,2,3)
    val list = listOf(1,2,3)
    val arraylist = arrayListOf(1,2,"dd")

    arraylist[0]="HONGs"


    var stc = "hong"
    var sts :String? = "nog"

    var cc = stc+(sts?:"NoLAST")
    var email = null
    email?.let{
        print("$it")
    }
    print(cc)

}
//null반환은 ?붙이면 다 가능.