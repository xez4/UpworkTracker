package com.android.upworktracker.bottom_sheet.category

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface CategoryView : MvpView {
    fun initAdapter(adapter: CategoryAdapter)
}