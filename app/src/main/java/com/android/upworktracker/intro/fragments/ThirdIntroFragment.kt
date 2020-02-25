package com.android.upworktracker.intro.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.upworktracker.R
import nl.dionsegijn.konfetti.KonfettiView
import nl.dionsegijn.konfetti.ParticleSystem
import nl.dionsegijn.konfetti.models.Shape
import nl.dionsegijn.konfetti.models.Size

class ThirdIntroFragment : BaseFragment() {

    lateinit var ribbon: KonfettiView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third_intro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ribbon = activity?.findViewById(R.id.confettiView) as KonfettiView

    }

    override fun onResume() {
        super.onResume()
        ribbon.build()
            .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
            .setDirection(0.0, 359.0)
            .setSpeed(1f, 5f)
            .setFadeOutEnabled(true)
            .setTimeToLive(2000L)
            .addShapes(Shape.RECT, Shape.CIRCLE)
            .addSizes(Size(12))
            .setPosition(-50f, ribbon.width + 50f, -50f, -50f)
            .streamFor(300, 5000L)
    }
}