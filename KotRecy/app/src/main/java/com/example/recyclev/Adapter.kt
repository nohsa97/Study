package com.example.recyclev

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.person.view.*

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

    lateinit var listener : onPersonItemClickListener

    var items = ArrayList<UserData>()

    inner class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

            init {
                itemView.setOnClickListener{
                    listener?.onItemClick(this,itemView,adapterPosition)
                }
            }

            fun bind(item:UserData){
                itemView.output1.text = item.name
                itemView.output2.text = item.phone
            }
    } // 바인드

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val itemView =   LayoutInflater.from(parent.context).inflate(R.layout.person,parent,false)
      return ViewHolder(itemView)

    } //parent 아이템 레이아웃 객체. view객체의 최상위 레이아웃
    //


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }// 바뀌는 정보를 부여 데이터를 설정.



}