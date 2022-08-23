package com.example.kotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test()



    }

    fun test () {
        val sb = StringBuilder()
        val str = "sdf"
        str?.let {
            println(it)
            sb.append(it).append("sdfsdf")
            it = sb.toString()
        }
//        sb.append(str).append("sdfsdf")
        println(sb)
        }
    }
