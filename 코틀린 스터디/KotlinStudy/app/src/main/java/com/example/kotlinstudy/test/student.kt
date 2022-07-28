package com.example.kotlinstudy.test

import android.widget.TextView

class student : person{

    constructor(name2: String?,age:Int?,add:String):super(name2){
        this.age=age
        this.phone = add
    }

    override fun walk(out:TextView){
        out.text= "학생이 걷는다."
    }

}