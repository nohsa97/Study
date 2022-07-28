package com.example.kotstudy4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
           val nums =  arrayOf("1st","2nd","3rd")
           val names = Array<String>(3,{ index -> "홍길동${index+1}"})
           val nuls = arrayOfNulls<String>(3)

           output.append("\n names: ${Arrays.toString(names)}")
            output.append("\n numb: ${Arrays.toString(nums)}")

            val digits = arrayOf(1,2,3)
            digits.set(1,10)
            val gets = digits.get(1)


            for (i in digits) {
                output.append("\n$i")
            }

//            val iter= digits.iterator()
//            while(iter.hasNext()){
//                output.append("${iter.next()}")
//            }

            val sorted = digits.sortedArray()
            for (i in sorted) {
                output.append("\n$i")
            }

            sorted.filter { elem -> elem>1}.forEach {
                output.append("\n$it")
            }
        }

        btn2.setOnClickListener {
            var names =  listOf("홍길","노홍","집안")

            var namesS = mutableListOf<Any>(1,3,"Hong")
            var adds = arrayListOf<Any>()
            adds.add(100)
            namesS.add(51)
            output.append("\n${namesS.joinToString()}")
        }
    }
}