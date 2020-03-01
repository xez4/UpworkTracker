package com.android.upworktracker.intro.fragments

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.android.upworktracker.R

abstract class BaseFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutResId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = view.findViewById<TextView>(R.id.fragmentHeaderTextView)
        val multiColoredHeader = SpannableString(textView.text)
        multiColoredHeader.setSpan(
                ForegroundColorSpan(resources.getColor(R.color.lima)),
                0,
                2,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        textView.text = multiColoredHeader
    }

    abstract fun getLayoutResId(): Int

}