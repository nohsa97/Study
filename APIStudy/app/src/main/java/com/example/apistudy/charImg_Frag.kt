package com.example.apistudy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_char_img.*
import kotlinx.android.synthetic.main.fragment_char_img.view.*


class charImg_Frag : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var userServer = arguments?.getString("server")
        var userName = arguments?.getString("name")
        var userJob = arguments?.getString("job")
        var userCharId = arguments?.getString("id")
        val url = "https://img-api.neople.co.kr/df/servers/${userServer}/characters/${userCharId}?zoom=1"
        val default = R.drawable.ic_launcher_foreground
        val view = inflater.inflate(R.layout.fragment_char_img, container, false)

        Glide.with(this)
            .load(url)
            .placeholder(default)
            .error(default)
            .into(view.imageView)
//            .load(url) // 불러올 이미지 url
//            .placeholder(defaultImage) // 이미지 로딩 시작하기 전 표시할 이미지
//            .error(defaultImage) // 로딩 에러 발생 시 표시할 이미지
//            .fallback(defaultImage) // 로드할 url 이 비어있을(null 등) 경우 표시할 이미지
//            .circleCrop() // 동그랗게 자르기
//            .into(imageView) // 이미지를 넣을 뷰
        view.charName.text = userName
        view.charJob.text = userJob


        return view
    }




}