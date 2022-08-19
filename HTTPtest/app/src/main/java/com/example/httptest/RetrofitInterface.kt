package com.example.httptest

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("/data")
    fun home() : Call<User>
}