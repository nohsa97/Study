package com.example.text33.retorifit

import android.util.Log
import com.example.text33.retorifit.RetrofitClient.getClient
import com.example.text33.util.API
import com.example.text33.retorifit.RetrofitInter
import com.example.text33.util.Constant.TAG
import com.example.text33.util.RESPONSE_STATE
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response

class RetrofitMan {

    //
    companion object {
        val instance = RetrofitMan()
    }

    //http코만들기
    private val retrofitInterface: RetrofitInter? = RetrofitClient.getClient(API.BASE_URL)?.create(RetrofitInter::class.java)

    //사진검색 api호출
    fun searchPhotos(searchTerm : String? , complet : (RESPONSE_STATE,String)->Unit){
        val term = searchTerm ?: ""
//        val call = retrofitInterface?.searchPhotos(searchTerm = term).let {it}?: return
        val call = retrofitInterface?.searchPhotos(searchTerm=term)?: return

        call.enqueue(object  : retrofit2.Callback<JsonElement> {
            //응답성공
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG, "onResponse: 성공 / response : ${response.body()}")
                complet(RESPONSE_STATE.OKAY,response.body().toString())
            }
            //응답실패
            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "onResponse: 실패 ")
                complet(RESPONSE_STATE.FAIL,t.toString())
            }

        })



    }
}