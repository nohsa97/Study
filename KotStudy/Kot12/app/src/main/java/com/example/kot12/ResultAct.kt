package com.example.kot12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        intent?.apply {
            proccessIntent(intent)
        }


    }


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.apply {
            proccessIntent(intent)
        }
    }

    fun proccessIntent(passedintent:Intent) {
        passedintent.extras?.apply {
            val inputName = getString("KEY2")
            output1.text = inputName
        }

    }
}