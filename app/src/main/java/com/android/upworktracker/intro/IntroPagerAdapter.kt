package com.android.upworktracker.intro

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class IntroPagerAdapter(
    fragmentManager: FragmentManager,
    private val introFragments: List<Fragment>
) :
    FragmentPagerAdapter(
        fragmentManager,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {
    override fun getItem(position: Int): Fragment {
        return introFragments[position]
    }

    override fun getCount(): Int {
        return introFragments.size
    }

}