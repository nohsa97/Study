package com.example.kotstu11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.HttpResponse
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.kotstu11.data.*
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        var requestQueue: RequestQueue? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestQueue = Volley.newRequestQueue(applicationContext)

        button.setOnClickListener {
            requsetBoxOffice()
        }
    }


    fun requsetBoxOffice() {
        var apiKey = "f5eef3421c602c6cb7ea224104795888"
        var targetId = "20220710"
        val url =
            "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=$apiKey&targetDt=$targetId"
        val request = object : StringRequest(
            Request.Method.GET,
            url,
            { //정상응답
                //printlog("응답 -> $it")

                ResponseFun(it)
            },
            { //에러
                printlog("에러 -> ${it.message}")
            }
        ) {
        }

        request.setShouldCache(false)
        requestQueue?.add(request)
       // printlog("요청함")

    }

    fun printlog(mes: String) {
        logs.append("$mes\n")
    }

    fun ResponseFun(response: String){
        val gson = Gson()

        val boxOfficeResponse =gson.fromJson(response,BoxOfficeResponse::class.java)
        printlog("영화 정보의 갯수 : ${boxOfficeResponse.boxOfficeResult.dailyBoxOfficeList.size}")

        val movieList = boxOfficeResponse.boxOfficeResult.dailyBoxOfficeList

        //printlog("1위 기록 : ${movieList[0].movieNm}")

        requestDetails(movieList)
    }

    fun  requestDetails(movieList:ArrayList<MovieInfo>){
        for ( index in 0..9) {
            requestMovieDetails(index,movieList[index])
        }
    }

    fun requestMovieDetails(index:Int,movieInfo: MovieInfo ) {
        var apiKey = "f5eef3421c602c6cb7ea224104795888"
        var movieCd = movieInfo.movieCd
        val url =
            "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=${apiKey}&movieCd=${movieCd}"
        val request = object : StringRequest(
            Request.Method.GET,
            url,
            { //정상응답
               // printlog("응답 -> $it")

                processDetailResponseFun(index,it)
            },
            { //에러
                printlog("에러 -> ${it.message}")
            }
        ) {
        }

        request.setShouldCache(false)
        requestQueue?.add(request)
        printlog("영화 상세 요청함")
    }

    fun processDetailResponseFun(index:Int,response: String){
        val gson = Gson()

        val movieDetails =gson.fromJson(response,MovieDetailsResponse::class.java)
        val movieNm = movieDetails.movieInfoResult.movieInfo.movieNm
        val movieEm = movieDetails.movieInfoResult.movieInfo.movieNmEn
        //printlog("영화 제목  : ${movieEm},${movieNm}")

        //TMDB요청

        if(movieDetails.movieInfoResult.movieInfo.nations[0].nationNm=="한국")
        {
            requestTmdbSearch(index,movieNm)
        } else
        {
            requestTmdbSearch(index,movieEm)
        }





    }

    fun requestTmdbSearch(index: Int,movieNm:String){

        var apiKey = "f5eef3421c602c6cb7ea224104795888"
        val url ="https://api.themoviedb.org/3/search/movie?api_key=47af33baa8addbe18b55ab7f9f0cd2bb&language=ko-KR&query=${movieNm}"
        val request = object : StringRequest(
            Request.Method.GET,
            url,
            { //정상응답
                //printlog("응답Tmdb -> $it")

                processTmdbResponse(index,it)
            },
            { //에러
                printlog("에러 -> ${it.message}")
            }
        ) {
        }

        request.setShouldCache(false)
        requestQueue?.add(request)
        printlog("TMDB검색요청 ")
    }

    fun processTmdbResponse(index:Int,response: String) {
        val gson = Gson()

        val TmdbmovieDetails = gson.fromJson(response, TmdbSearchResponse::class.java)
        //TmdbmovieDetails.results[0].poster_path
        //printlog("실행? 영화 포스터  : ${TmdbmovieDetails.results[0].poster_path}")
        if (index <3) {
            var targetOutput = out1
            when (index)
            {
                0 -> targetOutput = out1
                1 -> targetOutput =out2
                2 -> targetOutput =out3
            }

            val url = "https://image.tmdb.org/t/p/w500/${TmdbmovieDetails.results[0].poster_path}"
            Glide.with(this)
                .load(url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .dontAnimate()
                .into(targetOutput)
        }

    }

}