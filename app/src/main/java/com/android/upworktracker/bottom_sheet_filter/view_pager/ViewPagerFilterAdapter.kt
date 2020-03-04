package com.android.upworktracker.bottom_sheet_filter.view_pager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerFilterAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    lateinit var filterFragment: FilterFragment
    lateinit var categoryFragment: CategoryFragment

    private val pageCount = 2

    override fun getItemCount() = pageCount

    override fun createFragment(position: Int): Fragment {
        filterFragment = FilterFragment.newInstance()
        categoryFragment = CategoryFragment.newInstance()
        return when (position) {
            0 -> filterFragment
            else -> categoryFragment
        }
    }
}