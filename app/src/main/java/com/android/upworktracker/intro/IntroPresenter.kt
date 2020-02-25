package com.android.upworktracker.intro

import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.android.upworktracker.intro.fragments.FirstIntroFragment
import com.android.upworktracker.intro.fragments.SecondIntroFragment
import com.android.upworktracker.intro.fragments.ThirdIntroFragment
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class IntroPresenter : MvpPresenter<IntroView>() {

    fun notifyNextButtonClick(viewPager: ViewPager, size: Int) {
        val nextPageItem = viewPager.currentItem + 1

        if (nextPageItem < size) {
            viewPager.currentItem = nextPageItem
        } else {
            viewState.finishActivity()
        }
    }

    fun initializeViewPager() = ArrayList<Fragment>().apply {
        add(FirstIntroFragment())
        add(SecondIntroFragment())
        add(ThirdIntroFragment())
    }

}