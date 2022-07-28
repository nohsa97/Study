package com.example.kotstu11.data


import com.google.gson.annotations.SerializedName

data class BoxOfficeTest(
    @SerializedName("boxOfficeResult")
    val boxOfficeResult: BoxOfficeResult
) {
    data class BoxOfficeResult(
        @SerializedName("boxofficeType")
        val boxofficeType: String,
        @SerializedName("showRange")
        val showRange: String,
        @SerializedName("dailyBoxOfficeList")
        val dailyBoxOfficeList: ArrayList<DailyBoxOffice>
    ) {
        data class DailyBoxOffice(
            @SerializedName("rnum")
            val rnum: String,
            @SerializedName("rank")
            val rank: String,
            @SerializedName("rankInten")
            val rankInten: String,
            @SerializedName("rankOldAndNew")
            val rankOldAndNew: String,
            @SerializedName("movieCd")
            val movieCd: String,
            @SerializedName("movieNm")
            val movieNm: String,
            @SerializedName("openDt")
            val openDt: String,
            @SerializedName("salesAmt")
            val salesAmt: String,
            @SerializedName("salesShare")
            val salesShare: String,
            @SerializedName("salesInten")
            val salesInten: String,
            @SerializedName("salesChange")
            val salesChange: String,
            @SerializedName("salesAcc")
            val salesAcc: String,
            @SerializedName("audiCnt")
            val audiCnt: String,
            @SerializedName("audiInten")
            val audiInten: String,
            @SerializedName("audiChange")
            val audiChange: String,
            @SerializedName("audiAcc")
            val audiAcc: String,
            @SerializedName("scrnCnt")
            val scrnCnt: String,
            @SerializedName("showCnt")
            val showCnt: String
        )
    }
}