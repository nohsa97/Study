package com.example.kotstu7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_login.view.*


class LoginFragmen : Fragment() {
            //oncreateview 와 oncreate와 비슷
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,   savedInstanceState: Bundle? ): View? {

        val rootView = inflater.inflate(R.layout.fragment_login, container, false)

        rootView.nextBtn.setOnClickListener {
          val activityMain = activity as MainActivity
            activityMain.onFragement(1)
        }
                return rootView
    }

}