package com.example.apistudy

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_char_img.*


class charImg : Fragment() {

    override fun onStart() {
        super.onStart()
        println("프래그먼트시작함.")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val data = arguments?.getString("KEY")
//        charName.text = data
        println("받았음.${data}")

        return inflater.inflate(R.layout.fragment_char_img, container, false)
    }




}