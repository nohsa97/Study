package com.example.test32

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*



class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        num.imeOptions =  EditorInfo.IME_ACTION_SEND

        num.setOnEditorActionListener { v, actionID, keyEvent ->
            if(actionID == EditorInfo.IME_ACTION_DONE) {
                loginfun(v)
                true
            }
            else false
        }

    }

    fun loginfun (v:View) {
        //숨기기
        var imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v.windowToken,0)

        if(ID.text.toString()=="nohsa97" && pass.text.toString()=="1234" && num.text.toString()=="1234"){
            shortToast("로그인 완료")
            //숨기기
            var imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(v.windowToken,0)

            var intent = Intent(this,MainActivity::class.java)
            intent.putExtra("값","nohsa97")
            startActivity(intent)

            var editor =  this.getPreferences(0).edit()
        }
        else
            shortToast("로그인 실패")
    }

    fun shortToast (str : String){
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show()
    }
}
