package com.example.kotstu6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        check.setOnClickListener{
                var person1 = Person()
                person1?.name = "노홍석"
                person1?.age = 25
                person1?.phone = "01020207854"

                var person2 = Person().apply {
                    name = "이지"
                    age = 25
                    phone = "01022223333"
                }

            with(person2) {
                Toast.makeText(this@MainActivity,"${name}",Toast.LENGTH_SHORT).show()
                Toast.makeText(this@MainActivity,"${name}",Toast.LENGTH_SHORT).show()
                Toast.makeText(this@MainActivity,"${name}",Toast.LENGTH_SHORT).show()
            }

            person2?.let {
                Toast.makeText(this@MainActivity,"${it.name}",Toast.LENGTH_SHORT).show()
                Toast.makeText(this@MainActivity,"${it.name}",Toast.LENGTH_SHORT).show()
                Toast.makeText(this@MainActivity,"${it.name}",Toast.LENGTH_SHORT).show()
            } ?:run {
                println("객채가 null")
            } // also , with , let run 체크하기.
            }
    }
}