package com.example.kot12

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyService : Service() {

    override fun onCreate() {
        super.onCreate()
        println("oncreat")
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("onstart com")

        intent?.apply {
            proceessIntent(intent)
        }

        return super.onStartCommand(intent, flags, startId)
    }

    fun proceessIntent(intent: Intent) {
        intent.extras?.apply {
            val inputName = getString("KEY")
            println("전달된 이름 : ${inputName}")

            val showIntent = Intent(applicationContext,ResultAct::class.java)
            showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK+
            Intent.FLAG_ACTIVITY_SINGLE_TOP+
            Intent.FLAG_ACTIVITY_CLEAR_TOP)
            showIntent.putExtra("KEY2",inputName)
            startActivity(showIntent)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        println("onDest")
    }

    override fun onBind(intent: Intent): IBinder {
        TODO()
    }
}