package com.example.apistudy

import com.google.gson.annotations.SerializedName

data class equipment (
    @SerializedName("itemName")
    var itemName : String?,
    @SerializedName("itemType")
    var itemType : String?,
    @SerializedName("itemId")
    var itemId : String?
        )