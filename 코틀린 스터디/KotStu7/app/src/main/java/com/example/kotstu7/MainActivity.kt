package com.example.kotstu7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var loginFragmen:LoginFragmen = LoginFragmen()
    var menuFragmen:MenuFragmen = MenuFragmen()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showID.setOnClickListener {
//            supportFragmentManager.beginTransaction().replace(R.id.container,LoginFragmen()).commit()

//            with(supportFragmentManager.beginTransaction()){
//                replace(R.id.container,loginFragmen)
//            }.commit()
            onFragement(0)
        }
        showMenu.setOnClickListener {
//            supportFragmentManager.beginTransaction().replace(R.id.container,menuFragmen).commit()
            onFragement(1)
        } //위아래가 비슷한 형태

    }

    fun onFragement(index:Int) {
        when(index) {
            0 -> {
                with(supportFragmentManager.beginTransaction()){
                    replace(R.id.container,loginFragmen)
                }.commit()
            }
            1 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container,menuFragmen).commit()
                } //위아래가
            }
        }
    }