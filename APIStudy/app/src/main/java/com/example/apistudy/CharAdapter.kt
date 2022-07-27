package com.example.apistudy

import com.google.gson.annotations.SerializedName

data class CharAdapter (
        @SerializedName("rows")
        val rows : ArrayList<CharAbout>
        )