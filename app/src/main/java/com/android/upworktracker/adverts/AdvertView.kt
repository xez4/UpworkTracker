package com.android.upworktracker.adverts

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface AdvertView : MvpView {
    fun refresh()
    fun setToolbar()
    fun initAdapter(advertAdapter: AdvertAdapter)
    fun finishAdvertActivity()
}