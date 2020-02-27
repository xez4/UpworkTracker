package com.android.upworktracker.intro

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.upworktracker.intro.fragments.FirstIntroFragment

class IntroViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {

    private val pagesCount = 3

    override fun getItemCount(): Int = pagesCount

    override fun createFragment(position: Int): Fragment = ()

}