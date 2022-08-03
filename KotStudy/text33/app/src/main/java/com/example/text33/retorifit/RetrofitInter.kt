package com.example.text33.retorifit

import com.example.text33.util.API
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitInter {

        // https~.com/search/photos/?query="매개변수" 가 베이스.
        //
    @GET(API.SEARCH_PHOTO)
    fun searchPhotos (@Query("query") searchTerm : String) : Call<JsonElement>

    @GET(API.SEARCH_USER)
    fun searchUsers(@Query("query") searchTerm: String) : Call<JsonElement>

}