package com.android.upworktracker.intro

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.airbnb.lottie.LottieAnimationView
import com.android.upworktracker.R
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

    fun notifyPageScrolled(
        position: Int,
        ribbon: LottieAnimationView,
        ribbonSecond: LottieAnimationView
    ) {
        if (position == 2) {
            with(ribbon) {
                if (!this.isAnimating) {
                    setAnimation(R.raw.lottie_ribbon_animation)
                    playAnimation()
                    repeatCount = com.airbnb.lottie.LottieDrawable.INFINITE
                    speed = 0.5f

                    with(ribbonSecond) {
                        if (!this.isAnimating) {
                            setAnimation(R.raw.lottie_ribbon_animation)
                            repeatMode = com.airbnb.lottie.LottieDrawable.RESTART
                            setMinAndMaxFrame(25, 150)
                            playAnimation()
                            repeatCount = com.airbnb.lottie.LottieDrawable.INFINITE
                            speed = 0.5f
                        }
                    }
                }
            }
        }
    }


}