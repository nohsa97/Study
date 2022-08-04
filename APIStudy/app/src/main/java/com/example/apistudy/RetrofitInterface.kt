package com.example.apistudy

import retrofit2.Call
import retrofit2.http.*

interface RetrofitInterface {

//    @GET("/df/servers/:serverId/characters")
//    fun getUser(@Path("api_key") key:String) : Call<UserAPI>
//    @GET("/df/servers?apikey=ftGps3IDmP4kuCOlYx0yy19xm9BV3VR8")
//    fun getServer(): Call<ServerList>

    @GET("/df/servers")
    fun getServer(
        @Query("apikey") string:String
    ): Call<ServerList>


    @GET("/df/servers/{serverId}/characters")
    fun getChar(
        @Path("serverId")serverId:String?,
        @Query("characterName")characterName:String?,
        @Query("apikey") apikey:String?
                        ):Call<CharAdapter>

    @GET("/df/servers/{serverId}/characters/{characterId}/equip/equipment")
    fun getEqui(
        @Path("serverId")serverId: String?,
        @Path("characterId")charaterId:String?,
        @Query("apikey") apikey:String?
    ):Call<CharAbout_Equi>
//
//    @FormUrlEncoded
//    @POST
//    fun inputData (
//
//    )
}

