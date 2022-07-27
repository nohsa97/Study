package com.example.reciver

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.afollestad.assent.Permission
import com.afollestad.assent.askForPermissions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var receiver : BroadcastReceiver? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addReceiver()

        button.setOnClickListener {
            //카메라 위험권한 부여
            askForPermissions(Permission.CAMERA){
                println("위험권한 부여 결과 :  ${it.granted().size}")
            }

            // 끝
            val intents = Intent()
            intents.action = "org.techtown.send"
            intents.putExtra("USERNAME","노홍석")
            sendBroadcast(intents)
        }
    }

    fun addReceiver(){
        val filter = IntentFilter()
        filter.addAction("org.techtown.send")

        receiver = MyReceiver()
        registerReceiver(receiver,filter)
    }

    override fun onDestroy() {
        super.onDestroy()

        unregisterReceiver(receiver)
    }
}