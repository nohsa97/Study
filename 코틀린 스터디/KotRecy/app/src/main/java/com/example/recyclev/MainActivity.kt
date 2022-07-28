package com.example.recyclev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val layoutManger = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recycleV.layoutManager = layoutManger

        val adapter = Adapter()

        adapter.items.add(UserData("노홍석","010-2020-7854"))
        adapter.items.add(UserData("김진우","010-2020-5555"))
        adapter.items.add(UserData("김점례","010-2020-6666"))
        recycleV.adapter = adapter

        adapter.listener = object : onPersonItemClickListener {
            override fun onItemClick(holder: Adapter.ViewHolder?, view: View, position: Int) {
                Toast.makeText(this@MainActivity,"아이템 클릭됨 : ${position}",Toast.LENGTH_SHORT).show()
            }

        }

    }


}