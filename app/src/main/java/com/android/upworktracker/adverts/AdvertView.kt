package com.android.upworktracker.adverts

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface AdvertView : MvpView {
    fun refresh()
    fun setToolbar()
    fun initAdapter(advertAdapter: AdvertAdapter)
    fun finishAdvertActivity()
    fun hideProgress()
    fun hideProgressBarOnScroll()
}