package com.example.apistudy


import com.google.gson.annotations.SerializedName

data class ServerListTest(
    @SerializedName("rows")
    val rows: List<Row>
) {
    data class Row(
        @SerializedName("serverId")
        val serverId: String,
        @SerializedName("serverName")
        val serverName: String
    )
}