package com.example.kotstud10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pagerView.adapter = PagerAdapter(this)
        pagerView.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        pagerView.offscreenPageLimit = 3

        pagerView.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                showToast("페이지 선택 : $position")
            }
        })
    }

    fun showToast (mes:String) {
        Toast.makeText(applicationContext,mes,Toast.LENGTH_SHORT).show()
    }

    inner class PagerAdapter : FragmentStateAdapter {

        constructor(activity: FragmentActivity) : super(activity)


        override fun getItemCount() = 3

        override fun createFragment(position: Int): Fragment {
           return  when (position) {
                0 -> {
                    return firstFragment()

                }
                1 -> {
                    return secondFragment()

                }
                2 -> {
                    return thirdFragment()

                }
                else -> {
                    return firstFragment()
                }
            }
        }
    }
}