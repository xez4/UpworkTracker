package com.android.upworktracker.bottom_sheet.filter.inner_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.upworktracker.R

class FilterListAdapter(private val dataset: List<String>) :
    RecyclerView.Adapter<FilterListViewHolder>() {
    var check = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FilterListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.checkbox_item, parent, false)
        )

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: FilterListViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    fun checkAll() {
        check = true
        notifyDataSetChanged()
    }
}