package com.example.kotstu7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class MenuFragmen : Fragment() {
            //oncreateview 와 oncreate와 비슷
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,   savedInstanceState: Bundle? ): View? {

        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

}