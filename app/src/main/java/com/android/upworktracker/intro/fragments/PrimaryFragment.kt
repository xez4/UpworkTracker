package com.android.upworktracker.intro.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.android.upworktracker.R
import kotlinx.android.synthetic.main.fragment_intro.*

class PrimaryFragment : BaseFragment() {

    override fun getLayoutResId(): Int = R.layout.fragment_intro

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindContent(arguments!!.getInt("position"))
        super.onViewCreated(view, savedInstanceState)
    }

    private fun bindContent(position: Int) {
        if (getPageWelcomeHeader(position).isEmpty()) welcomeHeaderTextView.visibility = View.GONE

        welcomeHeaderTextView.text = getPageWelcomeHeader(position)
        fragmentHeaderTextView.text = getPageHeader(position)
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
            R.string.upwork_tracker_header,
            R.string.upwork_tracker_header,
            R.string.upwork_tracker_header
        )

        return getString(headerList[position])
    }

    private fun getPageTitle(position: Int): String {
        val titleList = listOf(
            R.string.first_fragment_title,
            R.string.second_fragment_title,
            R.string.third_fragment_title
        )

        return getString(titleList[position])
    }

    private fun getPageImage(position: Int): Drawable {
        val imagesList = listOf(
            R.drawable.first_fragment_picture,
            R.drawable.second_fragment_picture,
            R.drawable.third_fragment_picture
        )

        return resources.getDrawable(imagesList[position])
    }

    private fun getPageDescription(position: Int): String {
        val descriptionList = listOf(
            R.string.first_fragment_description,
            R.string.second_fragment_description,
            R.string.third_fragment_description
        )

        return getString(descriptionList[position])
    }

    companion object {
        fun getInstance(position: Int): PrimaryFragment {
            val primaryFragment = PrimaryFragment()

            primaryFragment.arguments = bundleOf("position" to position)

            return primaryFragment
        }
    }

}