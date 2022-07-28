package com.example.apistudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.*
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val API_KEY = getString(R.string.API_KEY)

        var userServer :String? =null

        val spinnerAdapter =  ArrayAdapter.createFromResource(
            this,
            R.array.serverName,
            android.R.layout.simple_spinner_dropdown_item
        ).also { arrayAdapter ->
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            serverLists.adapter = arrayAdapter
        }





        var userID : String? = "ea0ad6c1a617d19091a58ab4138e4995"



        button.setOnClickListener {
            userID = inputName.toString()


            val retrofit = Builder()
                .baseUrl("https://api.neople.co.kr")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(RetrofitInterface::class.java)


            println(API_KEY)
            val sp = getSharedPreferences("","")



           service.getServer(API_KEY)?.enqueue(object : Callback<ServerList> {
               override fun onResponse(call: Call<ServerList>, response: Response<ServerList>) {
                   if(response.isSuccessful) {
                       var sl  = response.body().toString()
                       var ss = response.body()?.serverList?.map {
                           Server(
                               it.ServerID,
                               it.ServerName
                           )
                       } // 서버를 하나의 데이터 클래스로 초기화

                    for (item in ss!!) {
                        println("${item.ServerID}는 한글로 ${item.ServerName}")
                    } //널이면 안되니까 !!


                   }
                   else {
                       println("실패")
                   }
               }

               override fun onFailure(call: Call<ServerList>, t: Throwable) {
                   println("서버 동기화 실패")
               }
           })
        }

        button2.setOnClickListener {
            userID = inputName.toString()

            val slss = resources.getStringArray(R.array.serverName)


            val userAPI = UserAPI(userServer,userID,"ea4ecc8062dc206be5fc82f41dff243e")

            val retrofit = Builder()
                .baseUrl("https://api.neople.co.kr")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(RetrofitInterface::class.java)


            serverLists.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    when(position) {
                        0 -> userServer = "안고름"
                        1 -> userServer = "anton"
                        2 -> userServer = "bakal"
                        3 -> userServer = "cain"
                        4 -> userServer = "casillas"
                        5 -> userServer = "diregie"
                        6 -> userServer = "hilder"
                        7 -> userServer = "prey"
                        8 -> userServer = "siroco"
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                   println("ㄴㄴ")
                }
            }

            val userName = inputName.text.toString()



            println("$userName $userServer ${slss[0]}")

            val userChar = service.getChar(userServer,userName,API_KEY)?.enqueue(object : Callback<CharAdapter> {
                override fun onResponse(call: Call<CharAdapter>, response: Response<CharAdapter>) {
                    if(response.isSuccessful) {
                        var uses : CharAbout? = null

                        var name = response.body()?.rows?.forEach {
                            uses = it.copy()
                        }


                        out4.text = "${uses!!.charId}"
                        out1.text = "${uses!!.serverId}"
                        out2.text = "${uses!!.charName}"
                        out3.text = "${uses!!.jobGrowName}"




                    }
                    else {
                        println("실패")
                    }
                }

                override fun onFailure(call: Call<CharAdapter>, t: Throwable) {
                    println("서버 동기화 실패")
                }
            })


        }



    }
}