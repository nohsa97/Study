package com.example.apistudy

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
            val pathData = intent.getSerializableExtra("charData") as CharAbout

            val bundle = Bundle()
            bundle.putString("server",pathData.serverId)
            bundle.putString("name",pathData.charName)
            bundle.putString("id",pathData.charId)
            bundle.putString("job",pathData.jobGrowName)







            menuBar.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.tap1 -> {
                        with(supportFragmentManager.beginTransaction()) {
                            val seltFragment = charImg_Frag()
                            seltFragment.arguments = bundle
                            replace(R.id.container, seltFragment)
                        }.commit()

                    }
                    R.id.tap2 -> {
                        with(supportFragmentManager.beginTransaction()) {
                            val seltFragment = charEqui_Frag()
                            seltFragment.arguments = bundle
                            replace(R.id.container, seltFragment)
                        }.commit()

                    }
                    R.id.tap3 -> {
                        with(supportFragmentManager.beginTransaction()) {
                            val seltFragment = charInfo_Frag()
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