package com.example.httptest

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit  = Retrofit.Builder().baseUrl("http://127.0.0.1:8000/").addConverterFactory(
            GsonConverterFactory.create()).build()
        val service = retrofit.create(RetrofitInterface::class.java)

        service!!.home().enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    var up  = response.body().toString()
                    println(up)
                    test.text = "up"
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                println("no")
            }

        })
    }
}