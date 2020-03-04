package com.android.upworktracker.bottom_sheet_filter

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.upworktracker.bottom_sheet_filter.inner_list.CategoryListAdapter
import kotlinx.android.synthetic.main.filter_title_list.view.*

class FilterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(str: Pair<String, List<String>>) = with(view){

        filterGroupRecyclerView.apply {
            adapter = CategoryListAdapter(str.second)
            layoutManager = LinearLayoutManager(view.context)
        }

        filterTitle.text = str.first
    }

}