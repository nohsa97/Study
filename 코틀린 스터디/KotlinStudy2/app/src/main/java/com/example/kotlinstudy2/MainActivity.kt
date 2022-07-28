package com.example.kotlinstudy2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var resul = 0


        btn1.setOnClickListener {
            var Calc1  = object : CalcInter {
                override fun add(a:Int,b:Int):Int{
                    return a+b
                }
            }
        }

        btn2.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
               println("버튼 클릭됨")
            }
        })

        btn2.setOnClickListener( { v:View? ->  println("버튼 클릭됨") })

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}