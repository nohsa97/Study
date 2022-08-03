package com.example.apistudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_next_page.*

class nextPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_page)

        if(intent.hasExtra("charName"))
        {
            val username = intent.getStringExtra("charName")
            val bundle = Bundle()
            bundle.putString("KEY",username)



//            with(supportFragmentManager.beginTransaction()) {
//                val charImg = charImg()
//                charImg.arguments = bundle
//                replace(R.id.container, charImg)
//            }.commit()

            menuBar.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.tap1 -> {

                        with(supportFragmentManager.beginTransaction()) {
                            val seltFragment = charImg()
                            seltFragment.arguments = bundle
                            replace(R.id.container, seltFragment)
                        }.commit()

                    }
                    R.id.tap2 -> {
                        with(supportFragmentManager.beginTransaction()) {
                            val seltFragment = charEqui()
                            replace(R.id.container, seltFragment)
                        }.commit()

                    }
                    R.id.tap3 -> {
                        with(supportFragmentManager.beginTransaction()) {
                            val seltFragment = charInfo()
                            replace(R.id.container, seltFragment)
                        }.commit()

                    }
                }
                return@setOnItemSelectedListener true
            }

        }
//        val intent = Intent()

    }
}