package com.android.upworktracker.intro.fragments

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.upworktracker.R
import com.android.upworktracker.intro.IntroActivity
import kotlinx.android.synthetic.main.fragment_first_intro.*

class FirstIntroFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first_intro, container, false)
    }

}
