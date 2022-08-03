package com.example.recyclev

import android.view.View

interface onPersonItemClickListener {

        fun onItemClick(holder:Adapter.ViewHolder?,view: View,position:Int)
}