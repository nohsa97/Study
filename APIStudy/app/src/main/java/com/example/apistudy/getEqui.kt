package com.example.apistudy

import android.content.Intent
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class getEqui {




    val API_KEY = "ftGps3IDmP4kuCOlYx0yy19xm9BV3VR8"


    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.neople.co.kr")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service = retrofit.create(RetrofitInterface::class.java)

    fun getEquiment() {
        service.getEqui("cain","ea0ad6c1a617d19091a58ab4138e4995",API_KEY)?.enqueue(object :Callback<CharAbout_Equi>{
            override fun onResponse (
                call: Call<CharAbout_Equi>,
                response: Response<CharAbout_Equi>
            ) {
                if(response.isSuccessful){
                    val body = response.body()?.toString()

                    val userEqui = response.body()?.equipment!!

                    for(item in userEqui) {
                        println("${item.itemName}이랑 아디는 ${item.itemId}")
                    }


                    val bundle = Bundle()
                    bundle.putString("itemId",userEqui[0].itemId)
                    bundle.putString("itemName",userEqui[0].itemName)
                    val seltFragment = charEqui_Frag()
                    seltFragment.arguments = bundle


                }
                else {
                    println("응답값 못받음 ㅠ")
                }
            }



            override fun onFailure(call: Call<CharAbout_Equi>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })


    }



}