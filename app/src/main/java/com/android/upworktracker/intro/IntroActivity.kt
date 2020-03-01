package com.android.upworktracker.intro

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.android.upworktracker.R
import com.android.upworktracker.adverts.AdvertActivity
import kotlinx.android.synthetic.main.activity_intro.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class IntroActivity : MvpAppCompatActivity(), IntroView {

    @InjectPresenter
    lateinit var introPresenter: IntroPresenter

    @ProvidePresenter
    fun provideIntroPresenter() = get<IntroPresenter>()

    private val introViewPagerAdapter = IntroViewPagerAdapter(this)

    private val sharedPreferences: SharedPreferences by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        introViewPager.adapter = introViewPagerAdapter
        introViewPager.offscreenPageLimit = 3

        pageIndicatorView.setViewPager2(introViewPager)

        nextPageButton.setOnClickListener {
            introPresenter.notifyNextButtonClick(introViewPager, introViewPagerAdapter.itemCount)
        }

        introViewPager.registerOnPageChangeCallback(onPageChangeListener)
    }

    override fun finishActivity() {
        startActivity(Intent(this, AdvertActivity::class.java))
        finish()
        sharedPreferences.edit().putBoolean("isFirstRun", false).apply()
    }

    private val onPageChangeListener = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
        ) {
            introPresenter.notifyPageScrolled(position, ribbonLottieAnimationView, ribbonLottieAnimationView2)
        }
    }

}
