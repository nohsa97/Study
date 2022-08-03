package com.example.teststudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val post = HashMap<String,String>()
        val test1= ssss.text.toString()
        val test2= ssss2.text.toString()

        post["id"] = test1
        post["pass"] = test2
        post["pss"]="mnooo"
        val post2 = LinkedHashMap<String,String>()
        post2["id"]=test1
        post2["pss"]=test2
        post2["pass"]="mxoxoxo"

        val sp = getSharedPreferences("테스트", MODE_PRIVATE)

        sp.edit().putString("id","nohsa97")
        sp.edit().putString("pass","1234")
        sp.edit().apply()



        button.setOnClickListener {
            println(post)
            println(post2)

           Log.d("로그확인 ","저장된 아디" + sp.getString("id","aa"))
           Log.d("로그확인 ","저장된 아디" + sp.getString("pass","aa"))
        }





    }
}