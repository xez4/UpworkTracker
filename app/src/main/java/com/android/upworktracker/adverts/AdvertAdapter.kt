package com.android.upworktracker.adverts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.upworktracker.R
import com.android.upworktracker.entity.TrackerResponse

class AdvertAdapter : RecyclerView.Adapter<AdvertViewHolder>() {

    private val adverts = mutableListOf<TrackerResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AdvertViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.adverts_card,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: AdvertViewHolder, position: Int) =
        holder.bind(adverts[position])

    override fun getItemCount() = adverts.size

    fun setData(items: MutableList<TrackerResponse>) {
        adverts.clear()
        adverts.addAll(items)
        notifyDataSetChanged()
    }

}