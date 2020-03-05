package com.android.upworktracker.bottom_sheet.category.inner_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.upworktracker.R
import com.android.upworktracker.entity.Description

class CategoryListAdapter(private val dataset: List<Description>) : RecyclerView.Adapter<CategoryListViewHolder>() {

    var check = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            CategoryListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.checkbox_item, parent, false))

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    fun checkAll() {
        check = true
        notifyDataSetChanged()
    }

}