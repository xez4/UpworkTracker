package com.android.upworktracker.bottom_sheet.filter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.upworktracker.R
import com.android.upworktracker.entity.Filter
import com.android.upworktracker.entity.Type

class FilterAdapter : RecyclerView.Adapter<FilterViewHolder>() {

    private val filter = mutableListOf<Filter>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder =
            FilterViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.filter_title_list, parent, false))


    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.bind(filter[position])
    }

    override fun getItemCount(): Int = filter.size

    fun setData(items : MutableList<Filter>){
        filter.clear()
        filter.addAll(items)
        notifyDataSetChanged()
    }
}