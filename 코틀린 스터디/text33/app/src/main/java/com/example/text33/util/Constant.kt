package com.example.text33.util

object Constant {
    const val TAG : String = "로그"
}

enum class SEARCH_TYPE {
    PHOTO,
    USER
}

enum class  RESPONSE_STATE {
    OKAY,
    FAIL
}

object API {
    const val BASE_URL : String = "https://api.unsplash.com/"

    const val CLIENT_ID : String = "qODQwfgAlv7oyzVweZL3vVZ4SIxIrD8D5dJqHBGmztw"

    const val SEARCH_PHOTO : String = "search/photos"
    const val SEARCH_USER : String = "search/users"
}