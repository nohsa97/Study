package com.example.laststu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.jsoup.Jsoup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            doTask()
        }
    }

    fun doTask(){
        val url = "https://movie.naver.com/movie/running/current.naver?view=list&tab=normal&order=likeCount"
        Single.fromCallable {
            val doc = Jsoup.connect(url).get()
            val elems = doc.select("ul.lst_detail_t1 li")
            elems.forEachIndexed { index, element ->
                val title = element.select("dt.tit a").text()
                val score1 = element.select("dl.info_star div.star_t1 span.num").text()
                val score2 = element.select("span.num2").text()
//                val reserve = element.select("dl.info_exp div.star_t1 span.num").text()

                println("#$index : $title, $score1 , $score2")
            }

            return@fromCallable title
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({text ->
                println("sucess")
            }, {
                println("error")
            })

    }
}