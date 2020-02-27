package com.android.upworktracker.intro.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.android.upworktracker.R
import kotlinx.android.synthetic.main.fragment_intro.*

class PrimaryFragment : Fragment() {

    companion object {
        fun getInstance(position: Int): PrimaryFragment {
            val primaryFragment = PrimaryFragment()
            primaryFragment.arguments = bundleOf("position" to position)
            return primaryFragment
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_intro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindContent(arguments!!.getInt("position"))
    }

    private fun bindContent(position: Int) {
        if (getPageWelcomeHeader(position).isEmpty()) {
            welcomeHeaderTextView.visibility = View.GONE
        }
        welcomeHeaderTextView.text = getPageWelcomeHeader(position)
        fragmentHeaderTextView.text = getPageHeader(position)
        setColorHeader(fragmentHeaderTextView)
        fragmentTitleTextView.text = getPageTitle(position)
        fragmentPictureImageView.setImageDrawable(getPageImage(position))
        fragmentDescriptionTextView.text = getPageDescription(position)
    }

    private fun getPageWelcomeHeader(position: Int): String {
        val headerList = listOf(
                getString(R.string.welcome_header),
                "",
                ""
        )
        return headerList[position]
    }

    private fun getPageHeader(position: Int): String {
        val headerList = listOf(
                getString(R.string.upwork_tracker_header),
                getString(R.string.upwork_tracker_header),
                getString(R.string.upwork_tracker_header)
        )
        return headerList[position]
    }

    private fun getPageTitle(position: Int): String {
        val titleList = listOf(
                getString(R.string.first_fragment_title),
                getString(R.string.second_fragment_title),
                getString(R.string.third_fragment_title)
        )
        return titleList[position]
    }

    private fun getPageImage(position: Int): Drawable {
        val imagesList = listOf(
                resources.getDrawable(R.drawable.first_fragment_picture),
                resources.getDrawable(R.drawable.second_fragment_picture),
                resources.getDrawable(R.drawable.third_fragment_picture)
        )
        return imagesList[position]
    }

    private fun getPageDescription(position: Int): String {
        val descriptionList = listOf(
                getString(R.string.first_fragment_description),
                getString(R.string.second_fragment_description),
                getString(R.string.third_fragment_description)
        )
        return descriptionList[position]
    }

    private fun setColorHeader(textView: TextView) {
        val multiColoredHeader = SpannableString(textView.text)
        multiColoredHeader.setSpan(
                ForegroundColorSpan(resources.getColor(R.color.lima)),
                0,
                2,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        textView.text = multiColoredHeader
    }

}