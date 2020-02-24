package com.android.upworktracker.intro.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView
import com.android.upworktracker.R
import com.android.upworktracker.intro.IntroActivity
import kotlinx.android.synthetic.main.fragment_third_intro.*

class ThirdIntroFragment : BaseFragment() {

    lateinit var ribbon: LottieAnimationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third_intro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ribbon = activity?.findViewById(R.id.ribbonLottieAnimationView) as LottieAnimationView
    }

    override fun onResume() {
        super.onResume()
        with(ribbon) {
            if (!this.isAnimating) {
                this.setAnimation(R.raw.lottie_ribbon_animation)
                this.playAnimation()
                this.repeatCount = 0
            }
        }
    }
}