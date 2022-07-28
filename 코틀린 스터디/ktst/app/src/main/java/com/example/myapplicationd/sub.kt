package com.example.myapplicationd

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class sub :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)


        val button = findViewById<Button>(R.id.btn2)
        button.setOnClickListener(View.OnClickListener {
            Log.d("태그","려차")
        })

        findViewById<Button>(R.id.btn3).setOnClickListener(View.OnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("key","보냄")
            startActivity(intent)

        })
    }


    public fun btnClick(v : View){
       val toast : Toast
       toast = Toast.makeText(this,"fuck",Toast.LENGTH_SHORT)
       toast.setGravity(Gravity.CENTER,10,10)
        toast.show()
    }
}