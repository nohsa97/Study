package com.example.kotlinstudy

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinstudy.test.person
import com.example.kotlinstudy.test.student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
          var name : String?
          var age : Int?
          var phone : String?

          name = InputName.text.toString()
          age = InputAge.text.toString().toInt()
          phone = InputPhone.text.toString()


          var persons :person? = person(name,age,phone)

          var UserData = persons?.name+persons?.age+persons?.phone
          shows(UserData)

          persons?.walk(TV)

        }

        button2.setOnClickListener {
            var name : String?
            var age : Int?
            var phone : String?

            name = InputName.text.toString()
            age = InputAge.text.toString().toInt()
            phone = InputPhone.text.toString()

            var stu :student? = student(name,age, phone!!)

            stu?.walk(TV)
        }

       }

      fun shows(mes:String) {
        Toast.makeText(applicationContext,mes,Toast.LENGTH_SHORT).show()
     }

    }

