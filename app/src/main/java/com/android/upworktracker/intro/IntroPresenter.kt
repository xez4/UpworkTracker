package com.android.upworktracker.intro

import androidx.viewpager2.widget.ViewPager2
import com.airbnb.lottie.LottieAnimationView
import com.android.upworktracker.R
import moxy.MvpPresenter

class IntroPresenter : MvpPresenter<IntroView>() {

    fun notifyNextButtonClick(viewPager: ViewPager2, size: Int) {
        val nextPageItem = viewPager.currentItem + 1

        if (nextPageItem < size) {
            viewPager.currentItem = nextPageItem
        } else {
            viewState.finishActivity()
        }
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
                    speed = 0.8f

                    with(ribbonSecond) {
                        if (!this.isAnimating) {
                            setAnimation(R.raw.lottie_ribbon_animation)
                            repeatMode = com.airbnb.lottie.LottieDrawable.RESTART
                            setMinAndMaxFrame(35, 140)
                            playAnimation()
                            repeatCount = com.airbnb.lottie.LottieDrawable.INFINITE
                            speed = 0.8f
                        }
                    }
                }
            }
        }
    }

}