package com.example.kotstu11.data

data class MovieDetailsInfo (
        val movieCd : String,
        val movieNm :String,
        val movieNmEn:String,
        val showTm:String,
        val openDt:String,
        val typeNm:String,

        val nations: ArrayList<NationInfo>,
        val genres: ArrayList<genresInfo>,
        val directors: ArrayList<directorsInfo>,
        val actors : ArrayList<actorsInfo>
        )

