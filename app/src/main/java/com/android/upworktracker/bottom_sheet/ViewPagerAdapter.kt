package com.android.upworktracker.bottom_sheet

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.upworktracker.bottom_sheet.category.CategoryFragment
import com.android.upworktracker.bottom_sheet.filter.FilterFragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

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