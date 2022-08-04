package com.example.apistudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.*
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var userData  = HashMap<String,String>()
        var userID:String? = null
        var data = CharAbout("","","","")


        val API_KEY = getString(R.string.API_KEY)

        var userServer :String? =null
        var userServer_Ko : String? = null

        val spinnerAdapter =  ArrayAdapter.createFromResource(
            this,
            R.array.serverName,
            android.R.layout.simple_spinner_dropdown_item
        ).also { arrayAdapter ->
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            serverLists.adapter = arrayAdapter
        }


        val retrofit = Builder()
            .baseUrl("https://api.neople.co.kr")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(RetrofitInterface::class.java)






//        var userID : String? = "ea0ad6c1a617d19091a58ab4138e4995"

        serverLists.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when(position) {
                    0 -> {
                        userServer = "안고름"
                        userServer_Ko = ""
                    }
                    1 -> {
                        userServer = "anton"
                        userServer_Ko = "안톤"
                    }
                    2 -> {
                        userServer = "bakal"
                        userServer_Ko = "바칼"
                    }
                    3 -> {
                        userServer = "cain"
                        userServer_Ko = "카인"
                    }
                    4 -> {
                        userServer = "casillas"
                        userServer_Ko = "카시아스"
                    }
                    5 -> {
                        userServer = "diregie"
                        userServer_Ko = "디레지에"
                    }
                    6 -> {
                        userServer = "hilder"
                        userServer_Ko = "힐더"
                    }
                    7 -> {
                        userServer = "prey"
                        userServer_Ko = "프레이"
                    }
                    8 -> {
                        userServer = "siroco"
                        userServer_Ko = "시로코"
                    }
                }


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                println("ㄴㄴ")
            }
        }



        button.setOnClickListener {

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
            userID = inputName.text.toString()
            if(userID =="" || userServer_Ko == "")
            {
                Toast.makeText(this,"캐릭터 설정을 해주세요",Toast.LENGTH_SHORT).show()
            }

            else {
                val slss = resources.getStringArray(R.array.serverName)


                val userAPI = UserAPI(userServer,userID,"ea4ecc8062dc206be5fc82f41dff243e")


                val userName = inputName.text.toString()

                val userChar = service.getChar(userServer,userName,API_KEY)?.enqueue(object : Callback<CharAdapter> {
                    override fun onResponse(call: Call<CharAdapter>, response: Response<CharAdapter>) {
                        if(response.isSuccessful) {
                            var uses : CharAbout? = null

                            var name = response.body()?.rows?.forEach {
                                uses = it.copy()
                            }

                            if(uses?.charId == null || uses?.charName == null || uses?.serverId == null) {
                                out1.text = "다시부탁드립니다."
                                out2.text = "다시부탁드립니다."
                                out3.text = "다시부탁드립니다."
                                out4.text = "다시부탁드립니다."
                            }

                            else {


                                out4.text = "${uses!!.charId}"
                                out1.text = "${uses!!.serverId}"
                                out2.text = "${uses!!.charName}"
                                out3.text = "${uses!!.jobGrowName}"

                                userData["charId"] = uses!!.charId
                                userData["serverId"] = uses!!.serverId
                                userData["charName"] = uses!!.charName
                                userData["jobGrowName"] = uses!!.jobGrowName

                                data = CharAbout(uses!!.serverId,uses!!.charId,uses!!.charName,uses!!.jobGrowName)
                            }


                        }
                        else {

                            println("실패")
                        }
                    }

                    override fun onFailure(call: Call<CharAdapter>, t: Throwable) {
                        println("${userServer} + ${userName}")
                        println("서버 동기화 실패")
                    }
                })
            }

        }

        button3.setOnClickListener {
            userID = inputName.text.toString()
            if(userID == "" || userData["charName"] == null || userServer_Ko == "") {
                Toast.makeText(this,"캐릭터 설정을 해주세요",Toast.LENGTH_SHORT).show()
            }
            else {
                val intent1 = Intent(this, nextPage::class.java)


                intent1.putExtra("charName", userData["charName"])
                intent1.putExtra("charData", data)

                startActivity(intent1)
            }
        }



    }
}