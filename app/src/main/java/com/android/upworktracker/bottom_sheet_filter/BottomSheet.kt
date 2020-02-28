package com.android.upworktracker.bottom_sheet_filter

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.upworktracker.R

import com.android.upworktracker.bottom_sheet_filter.viewPager.ViewPagerFilterAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.bottom_sheet_view_pager.*

class BottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.bottom_sheet_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomSheetViewPager.adapter = ViewPagerFilterAdapter(this)

        TabLayoutMediator(viewPagerTabLayout, bottomSheetViewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "filter"
                else -> "category"
            }
        }.attach()


    }

    override fun onDismiss(dialog: DialogInterface) {
    }

}