package com.example.kotstu6

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.FrameLayout
import androidx.core.view.marginTop
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() { //움직이기
    var startX =0.0f
    var startY = 0.0f

    var lmargin = 0
    var rmargin = 0
    var wids = 0.0f
    var heis = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wids = resources.getDimension(R.dimen.wids)
        heis = resources.getDimension(R.dimen.heis)
        
        selectImg.setOnTouchListener { v, event ->
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    println("이미지 눌림")

                    startX=event.x
                    startY=event.y
                }
                MotionEvent.ACTION_MOVE -> {
                    println("움직이는중")

                    var diffx = event.x-startX
                    var diffy = event.y-startY

                    lmargin = diffx.toInt()
                    rmargin = diffy.toInt()

                    val layoutParams = FrameLayout.LayoutParams(
                        wids.toInt(),heis.toInt()
                    )

                    layoutParams.leftMargin = lmargin
                    layoutParams.topMargin = rmargin

                    selectImg.layoutParams = layoutParams
                }
                MotionEvent.ACTION_UP ->{
                    println("손가락 띄어짐")
                }
            }

            return@setOnTouchListener true
        }
    }
}