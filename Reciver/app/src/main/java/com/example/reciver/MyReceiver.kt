package com.example.reciver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        println("onReceive 호출")

        val userName = intent.extras?.getString("USERNAME")

        println("이름 : ${userName}")
    }
}