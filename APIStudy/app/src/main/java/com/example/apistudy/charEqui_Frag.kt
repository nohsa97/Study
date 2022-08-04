package com.example.apistudy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_char_equi.view.*
import kotlinx.android.synthetic.main.fragment_char_img.view.*


class charEqui_Frag : Fragment() {
    val default = R.drawable.ic_launcher_foreground




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var userServer = arguments?.getString("server")
        var userName = arguments?.getString("name")
        var userJob = arguments?.getString("job")
        var userCharId = arguments?.getString("id")
        println("장비창에서 나오는 정보 ${userName}, ${userCharId}")
        val url = "https://img-api.neople.co.kr/df/servers/${userServer}/characters/${userCharId}?zoom=1"
        val default = R.drawable.ic_launcher_foreground
        val view2 = inflater.inflate(R.layout.fragment_char_equi, container, false)

        glide(this,url,inflater,view2,container)


        var userEqui = getEqui()
        userEqui.getEquiment()



        return view2
    }

    fun glide(fragment: Fragment,url:String,inflater: LayoutInflater , view : View,container: ViewGroup?) {


        Glide.with(fragment)
            .load(url)
            .placeholder(default)
            .error(default)
            .into(view.imageView4)
    }
}