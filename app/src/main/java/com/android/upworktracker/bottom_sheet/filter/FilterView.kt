package com.android.upworktracker.bottom_sheet.filter

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface FilterView : MvpView {
    fun initAdapter(adapter: FilterAdapter)
}