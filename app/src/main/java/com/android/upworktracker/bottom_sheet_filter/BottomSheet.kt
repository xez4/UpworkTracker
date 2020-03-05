package com.android.upworktracker.bottom_sheet_filter

import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.android.upworktracker.R
import com.android.upworktracker.bottom_sheet_filter.view_pager.ViewPagerFilterAdapter
import com.google.android.material.bottomsheet.BottomSheetBehavior
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

        val pagerAdaper = ViewPagerFilterAdapter(this)
        bottomSheetViewPager.adapter = pagerAdaper
        bottomSheetViewPager.offscreenPageLimit = 2

        TabLayoutMediator(viewPagerTabLayout, bottomSheetViewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "filter"
                else -> "category"
            }
        }.attach()

        clearButton.setOnClickListener {
            pagerAdaper.apply {
                when(bottomSheetViewPager.currentItem){
                    0 -> filterFragment.clearCheckboxes()
                    1 -> categoryFragment.clearCheckboxes()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()

        dialog.let {
            idBottomSheet.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
        }


        val view = view
        view?.post {
            val parent = view.parent as View
            val params = parent.layoutParams as CoordinatorLayout.LayoutParams
            val behavior = params.behavior
            val bottomSheetBehavior = behavior as BottomSheetBehavior
            bottomSheetBehavior.peekHeight = view.measuredHeight
            (idBottomSheet.parent as View).setBackgroundColor(Color.TRANSPARENT)
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
    }

}