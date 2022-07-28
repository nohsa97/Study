package com.example.kotlinstudy.test

class calc {
    open var name:String? = null

    init {
        println("생성자 호출")
    }

    fun add (a:Int,b:Int) : Int {
        return a+b
    }
}