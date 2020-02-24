package com.android.upworktracker.intro

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import com.android.upworktracker.R
import com.android.upworktracker.adverts.AdvertActivity
import kotlinx.android.synthetic.main.activity_intro.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.get

class IntroActivity : MvpAppCompatActivity(), IntroView {

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
    }

    override fun finishActivity() {
        startActivity(Intent(this, AdvertActivity::class.java))
        finish()
        getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE).edit()
            .putBoolean("isFirstRun", false).apply()
    }
}
