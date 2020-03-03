package com.android.upworktracker.intro

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IntroView : MvpView {
    fun finishActivity()
}