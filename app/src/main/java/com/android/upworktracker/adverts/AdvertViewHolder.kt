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

    fun bind(advert: TrackerResponse) = with(itemView) {
        recyclerTags.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        if (advert.skills == null) {
            recyclerTags.visibility = View.GONE
        }
        recyclerTags.adapter = TagsAdapter(advert.skills)
        titleAdvertText.text = advert.title.toLowerCase().capitalize()
        if (advert.budget == "") {
            costAdvertText.visibility = View.GONE
        }
        costAdvertText.text = advert.budget
        if (advert.category == "") {
            categoryAdvertText.visibility = View.GONE
        }
        categoryAdvertText.text = advert.category
        uploadDataText.text = formatDate(advert.date)
        countryAdvertText.text = advert.country
        descriptionAdvertText.text = advert.description.capitalize()
    }

    private fun formatDate(date: String): String {
        val inFormat = SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US)
        val date = inFormat.parse(date)
        val outputDate = SimpleDateFormat("HH:mm", Locale.US)
        return outputDate.format(date)
    }

}