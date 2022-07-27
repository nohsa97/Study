package com.example.test1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Test{
    companion object {
        val s = 20
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun main (){
        val s = 10

    }
}