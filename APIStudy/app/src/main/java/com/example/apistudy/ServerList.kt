package com.example.apistudy

import com.google.gson.annotations.SerializedName

data class ServerList (
    @SerializedName("rows")
    val serverList: ArrayList<Server>
        )