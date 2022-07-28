package com.example.kot12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startBtn.setOnClickListener {
            val inputName = input1.text.toString()
            val serviceIntent = Intent(applicationContext,MyService::class.java)
            serviceIntent.putExtra("KEY",inputName)
            startService(serviceIntent)
        }
    }
}