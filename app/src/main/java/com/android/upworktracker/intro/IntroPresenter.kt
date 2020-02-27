package com.android.upworktracker.intro

import androidx.viewpager2.widget.ViewPager2
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class IntroPresenter : MvpPresenter<IntroView>() {

    fun notifyNextButtonClick(viewPager: ViewPager2, size: Int) {
        val nextPageItem = viewPager.currentItem + 1

        if (nextPageItem < size) {
            viewPager.currentItem = nextPageItem
        } else {
            viewState.finishActivity()
        }
    }

//    fun initializeViewPager() = ArrayList<Fragment>().apply {
//        add(FirstIntroFragment())
//        add(SecondIntroFragment())
//        add(ThirdIntroFragment())
//    }

}