package com.example.apistudy

import com.google.gson.annotations.SerializedName

data class CharAbout (
        @SerializedName("serverId")
        val serverId : String,
        @SerializedName("characterId")
        val charId : String,
        @SerializedName("characterName")
        val charName: String,
        @SerializedName("jobGrowName")
        val jobGrowName : String
        )

