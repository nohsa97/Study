package com.example.test32

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val Datalist = arrayListOf(
        Data(R.drawable.mol,"0번"),
        Data(R.drawable.mol,"1번"),
        Data(R.drawable.mol,"2번"),
        Data(R.drawable.mol,"3번"),
        Data(R.drawable.mol,"4번"),
        Data(R.drawable.mol,"5번"),
        Data(R.drawable.mol,"6번"),
        Data(R.drawable.mol,"7번"),
        Data(R.drawable.mol,"8번"),
        Data(R.drawable.mol,"9번"),
        Data(R.drawable.mol,"10번")
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recy_view.layoutManager = LinearLayoutManager(this)
        recy_view.adapter = recy_custom(Datalist)


    }

    fun shortToast (str : String){
        Toast.makeText(this,str, Toast.LENGTH_SHORT).show()
    }
}