package com.example.apistudy

import com.google.gson.annotations.SerializedName

data class Server (
    @SerializedName("serverId")
    val ServerID : String,
    @SerializedName("serverName")
    val ServerName : String
        )