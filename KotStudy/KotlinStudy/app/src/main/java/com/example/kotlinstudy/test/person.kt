package com.example.kotlinstudy.test

import android.widget.TextView

open class  person (var name:String?){
    var age : Int? = null
    var phone :String? = null

    constructor(name: String?,age:Int?,add:String?) : this(name) {
            println("생성자 실행됨")
        this.age=age
        this.phone=add
    }

    open fun walk(out : TextView) {
        println("걷는다.")
        out.text = "사람이 걷는다."
    }


}