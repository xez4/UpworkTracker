package com.android.upworktracker.intro

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import com.airbnb.lottie.LottieAnimationView
import com.android.upworktracker.R
import com.android.upworktracker.adverts.AdvertActivity
import kotlinx.android.synthetic.main.activity_intro.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.get

class IntroActivity : MvpAppCompatActivity(), IntroView {

    lateinit var ribbon: LottieAnimationView
    lateinit var ribbonSecond: LottieAnimationView

    @InjectPresenter
    lateinit var introPresenter: IntroPresenter

    @ProvidePresenter
    fun provideIntroPresenter() = get<IntroPresenter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val introFragments = introPresenter.initializeViewPager()
        introViewPager.adapter = IntroPagerAdapter(supportFragmentManager, introFragments)

        nextPageButton.setOnClickListener {
            introPresenter.notifyNextButtonClick(introViewPager, introFragments.size)
        }

        ribbon = findViewById(R.id.ribbonLottieAnimationView)
        ribbonSecond = findViewById(R.id.ribbonLottieAnimationView2)

        introViewPager.addOnPageChangeListener(onPageChangeListener)
    }

    override fun finishActivity() {
        startActivity(Intent(this, AdvertActivity::class.java))
        finish()
        getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE).edit()
            .putBoolean("isFirstRun", false).apply()
    }

    private val onPageChangeListener = object : ViewPager.OnPageChangeListener {

        override fun onPageScrollStateChanged(state: Int) {
            //no-op
        }

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            introPresenter.notifyPageScrolled(position, ribbon, ribbonSecond)
        }

        override fun onPageSelected(position: Int) {
            //no-op
        }

    }
}
