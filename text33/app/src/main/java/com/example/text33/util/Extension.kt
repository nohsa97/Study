package com.example.text33.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

//문자열이 제이슨인지 문자열인지 판별

fun String?.isJsonObject():Boolean {
    if(this?.startsWith("{") == true && this.endsWith("}")) {
        return true
    }
    else {
        return false
    }
}

fun String?.isJsonArray():Boolean {
    if(this?.startsWith("[") == true && this.endsWith("]")) {
        return true
    }
    else {
        return false
    }
}

fun EditText.onMytextChanged(complet : (Editable?)->Unit) {
    this.addTextChangedListener(object : TextWatcher{
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun afterTextChanged(p0: Editable?) {
           complet(p0)
        }

    })
}