package com.android.upworktracker.intro

import android.widget.TextView
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface IntroView : MvpView {
    fun finishActivity()
}