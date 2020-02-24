package com.android.upworktracker.intro.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.upworktracker.R
import com.android.upworktracker.intro.IntroActivity
import kotlinx.android.synthetic.main.fragment_second_intro.*

class SecondIntroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second_intro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        IntroActivity().decorateTextView(secondFragmentHeaderTextView)
    }
}
