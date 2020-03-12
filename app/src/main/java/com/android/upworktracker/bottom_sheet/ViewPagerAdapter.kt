package com.android.upworktracker.bottom_sheet

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragment: Fragment, val bottomSheetFragments: List<BaseBottomSheetFragment>) :
    FragmentStateAdapter(fragment) {

    private val pageCount = 2

    override fun getItemCount() = pageCount

    override fun createFragment(position: Int) = bottomSheetFragments[position]

}