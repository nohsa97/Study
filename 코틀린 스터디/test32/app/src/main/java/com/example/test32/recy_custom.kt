package com.example.test32

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_list.view.*

class Data(val profile : Int , val name : String)

class customViewHolder (v:View) : RecyclerView.ViewHolder(v){
    val profile =  v.iv_custom
    val name = v.tv_custom
}
class recy_custom(val Datalist : ArrayList<Data>) : RecyclerView.Adapter<customViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): customViewHolder {
        val cellForRow = LayoutInflater.from(parent.context).inflate(R.layout.custom_list,parent,false)
        return customViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: customViewHolder, position: Int) {
        holder.name
    }

    override fun getItemCount()=Datalist.size
}