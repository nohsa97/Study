package com.example.kotstud3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_menu.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener{
            val inz = Intent(this,menuAct::class.java)
            inz.putExtra("key","보낼 메시지")

            startActivityForResult(inz,101)
        }

        showTo("onCreate")

        saveB.setOnClickListener{
            val inputs = input1.text.toString()

            val key = getSharedPreferences("key", MODE_PRIVATE)
            key.edit().putString("userName",inputs).commit()
        }
        loadB.setOnClickListener {
            val key = getSharedPreferences("key", MODE_PRIVATE)
            val userName = key.getString("userName","NoData")
            input1.setText(userName)

        }
    }

//    override fun onStart() {
//        super.onStart()
//
//        showTo("onStart")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        showTo("onResume")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        showTo("onPause")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        showTo("oonStop")
//    }


    override fun onDestroy() {
        super.onDestroy()
        showTo("onDestroy()")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        when (requestCode){
            101 -> {
                showTo("메뉴에서 응답보냄 : $requestCode, $resultCode")
                if(data != null){
                    processIntent(data)
                }
            }
        }
    }

    fun processIntent (pass : Intent) {
        val mes = pass.getStringExtra("data")
        if (mes!=null){
            showTo("메뉴에서 받음 $mes")
        }

//        mes?.run {
//            showTo(mes)
//        } 위랑 똑같이 동작 mes가 널이아니면


    }

    fun showTo (mes:String){
        Toast.makeText(applicationContext,mes,Toast.LENGTH_SHORT).show()

    }
}