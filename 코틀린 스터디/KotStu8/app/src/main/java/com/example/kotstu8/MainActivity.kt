package com.example.kotstu8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(supportFragmentManager.beginTransaction()){
            val firstFragment =firstFragment()
            replace(R.id.container,firstFragment)
        }.commit()

//        menuBar.setOnNavigationItemSelectedListener {
//            when(it.itemId) {
//                R.id.tap1 -> {
//
//                }
//                R.id.tap2 -> {
//
//                }
//                R.id.tap3 -> {
//
//                }
//        }
//            return@setOnNavigationItemSelectedListener true
//        }

        menuBar.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.tap1 -> {
                    with(supportFragmentManager.beginTransaction()){
                        val seltFragment =firstFragment()
                        replace(R.id.container,seltFragment)
                    }.commit()

                }
                R.id.tap2 -> {
                    with(supportFragmentManager.beginTransaction()){
                        val seltFragment =secondFragment()
                        replace(R.id.container,seltFragment)
                    }.commit()

                }
                R.id.tap3 -> {
                    with(supportFragmentManager.beginTransaction()){
                        val seltFragment =thirdFragment()
                        replace(R.id.container,seltFragment)
                    }.commit()

                }
            }
            return@setOnItemSelectedListener true
        } //위아래가 같은방법 다만 위는 권장 x

    }
}