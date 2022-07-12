package com.example.kotstud3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menu.*

class menuAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        menuBtn.setOnClickListener{
            val back = Intent()
            back.putExtra("data","돌아가라")
            setResult(201,back)
                finish()
        }

        if (intent !=null) {
            processIntent(intent)
        }
    }

    fun processIntent (pass : Intent) {
        val mes = pass.getStringExtra("key")
        if (mes!=null){
            showTo("메인에서 받음 $mes")
        }

//        mes?.run {
//            showTo(mes)
//        } 위랑 똑같이 동작 mes가 널이아니면


    }

    fun showTo (mes:String){
        Toast.makeText(applicationContext,mes, Toast.LENGTH_SHORT).show()

    }

}