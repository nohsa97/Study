package com.example.kot13

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val channelID = "noti"
    val channelName = "noti"
    val descrip = "noti TEST"

    lateinit var notiManger : NotificationManagerCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notiManger = NotificationManagerCompat.from(applicationContext)
        createNotificationChannel()

        button.setOnClickListener{
            showNotification("테스트","테스트입니다.")
        }
    }

    fun showNotification(title:String,con:String) {
        val resultIntent = Intent(application,MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(applicationContext,0,resultIntent,0)
        val notif = NotificationCompat.Builder(this,channelID)
            .setContentTitle(title)
            .setContentText(con)
            .setSmallIcon(android.R.drawable.ic_media_play)
            .setContentIntent(pendingIntent)
            .build()

        notif.flags = Notification.FLAG_NO_CLEAR
        notiManger.notify(101,notif)
    }

    fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_LOW
            val channel = NotificationChannel(channelID,channelName,importance)
            channel.description = descrip
            channel.enableLights(true)
            channel.lightColor = Color.GREEN
            channel.enableVibration(true)

            notiManger.createNotificationChannel(channel)
        }
    }
}