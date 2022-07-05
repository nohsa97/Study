package com.example.text33.retorifit

import android.content.ContentValues.TAG
import android.util.Log
import com.example.text33.util.API
import com.example.text33.util.isJsonArray
import com.example.text33.util.isJsonObject
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import javax.xml.transform.OutputKeys

object RetrofitClient {
    //클라선언
    private var retrofitClient : Retrofit? = null





    //레트로핏 클라 가져오기기
    fun getClient(baseUrl : String) : Retrofit? {
        Log.d(TAG, "getClient() called ")


        //로깅 인터셉터
        //okhttp인스턴트생성
        val client = OkHttpClient.Builder()


        //로그위해
        val logginInter  = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger{
            override fun log(message: String) {
                Log.d(TAG, "log: 호출된 로그 / message : $message")
                when {
                    message.isJsonObject() -> Log.d(TAG, JSONObject(message).toString(4))
                    message.isJsonArray() ->  Log.d(TAG, JSONObject(message).toString(4))
                    else -> {
                        try {
                            Log.d(TAG, JSONObject(message).toString(4))
                        }
                        catch (e: Exception) {
                            Log.d(TAG,message)
                        }
                    }
                }
            }

        })

        logginInter.setLevel(HttpLoggingInterceptor.Level.BODY)

        //위에서 설정한 로깅 인터셉터를 okhttp클라에 추가
        client.addInterceptor(logginInter)

        //기본 매개변수
        val basepara :Interceptor  =(object :Interceptor{

            override fun intercept(chain: Interceptor.Chain): Response {
                Log.d(TAG, "intercept: 호출")
                val original = chain.request()

                //쿼리파라 추가
//                val addede = original.url().newBuilder().addQueryParameter("ID",API.CLIENT_ID)
                val addedUrl = original.url().newBuilder().addQueryParameter("CLIENT_ID", API.CLIENT_ID)
                val final = original.url(addedUrl)
                            .newBuilder()
                            .method(original.method,original.body)
                            .build

                return chain.proceed(final)
            }
        })


        client.addInterceptor(basepara)

        if(retrofitClient == null){

            //레트로핏 빌더
            retrofitClient = Retrofit.Builder()
                .baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build()

            //위에 설정한 클라로 레트로핏 설정

        }
        return retrofitClient
    }
}