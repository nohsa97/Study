package com.example.apistudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_next_page.*
import kotlinx.android.synthetic.main.fragment_char_img.*
import org.w3c.dom.Text

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
                            val seltFragment = charImg()
                            seltFragment.arguments = bundle
                            replace(R.id.container, seltFragment)
                        }.commit()

                    }
                    R.id.tap2 -> {
                        with(supportFragmentManager.beginTransaction()) {
                            val seltFragment = charEqui()
                            seltFragment.arguments = bundle
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