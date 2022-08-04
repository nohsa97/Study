package com.example.apistudy

import com.google.gson.annotations.SerializedName

data class equipment (
    @SerializedName("itemName")
    val itemName : String?,
    @SerializedName("itemType")
    val itemType : String?,
    @SerializedName("itemId")
    val itemId : String?
        )