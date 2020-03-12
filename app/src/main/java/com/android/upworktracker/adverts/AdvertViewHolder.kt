package com.android.upworktracker.adverts

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.upworktracker.adverts.inner_list.TagsAdapter
import com.android.upworktracker.entity.TrackerResponse
import kotlinx.android.synthetic.main.adverts_card.view.*
import java.text.SimpleDateFormat
import java.util.*

class AdvertViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(advert: TrackerResponse, advertCallback: AdvertCallback) = with(itemView) {
        recyclerTags.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        if (advert.skills.isNullOrEmpty()) {
            recyclerTags.visibility = View.GONE
        }

        if (advert.budget.isEmpty()) {
            costAdvertText.visibility = View.GONE
        }


        if (advert.category.isEmpty()) {
            categoryAdvertText.visibility = View.GONE
        }

        costAdvertText.text = advert.budget
        recyclerTags.adapter = TagsAdapter(advert.skills)
        titleAdvertText.text = decode(advert.title.capitalize())
        categoryAdvertText.text = decode(advert.category)
        uploadDataText.text = formatDate(advert.date)
        countryAdvertText.text = advert.country
        descriptionAdvertText.text = decode(advert.description.capitalize())

        setOnClickListener { advertCallback.advertOnClickListener(advert.link) }

    }

    private fun decode(str: String) =
        str.replace("&amp;amp;", "&")
            .replace("&amp;", "&")
            .replace("&quot;", " \" ")
            .replace("&apos;", "\'")
            .replace("&lt;", "<")
            .replace("&gt;", ">")
            .replace("#039;", "\'")
            .replace("&rsquo;", "’")
            .replace("&lsquo;", "‘")
            .replace("#8217;", "’")
            .replace("&ndash;", "-")
            .replace("&mdash;", "-")
            .replace("&'", "\'")

    private fun formatDate(date: String): String {
        val inFormat = SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US)
        val formatDate = inFormat.parse(date)
        val outputDate = SimpleDateFormat("HH:mm", Locale.US)
        return outputDate.format(formatDate!!)
    }

}