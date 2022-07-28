package com.example.text33

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.text33.retorifit.RetrofitInter
import com.example.text33.retorifit.RetrofitMan
import com.example.text33.util.Constant.TAG
import com.example.text33.util.RESPONSE_STATE
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnGet.setOnClickListener {
            Log.d(TAG, "onCreate: 검색 버튼 클릭")
            RetrofitMan.instance.searchPhotos(searchTerm = search_term_edit_text.toString(), complet = {responseState,response->
                when(responseState){
                    RESPONSE_STATE.OKAY -> {
                        Log.d(TAG, "onCreate: 호출 성공 : $response")

                    }
                    RESPONSE_STATE.FAIL ->{
                        Toast.makeText(this,"호출에러",Toast.LENGTH_SHORT).show()
                        Log.d(TAG, "onCreate: 실패 : $response")
                    }
                }
            })
        }

        }


}
