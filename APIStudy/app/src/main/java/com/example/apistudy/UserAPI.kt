package com.example.apistudy

import com.google.gson.annotations.SerializedName

data class UserAPI (
    @SerializedName("serverId")
    val ServerID : String?,
    @SerializedName("characterName")
    val characterName : String?,
    @SerializedName("characterId")
    val characterID : String?
        )