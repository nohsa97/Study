package com.example.apistudy

import com.google.gson.annotations.SerializedName

data class CharAbout (
        @SerializedName("serverId")
        var serverId : String,
        @SerializedName("characterId")
        var charId : String,
        @SerializedName("characterName")
        var charName: String,
        @SerializedName("jobGrowName")
        var jobGrowName : String
        )

