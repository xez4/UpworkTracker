package com.android.upworktracker.bottom_sheet_filter

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.upworktracker.bottom_sheet_filter.inner_list.CategoryListAdapter
import kotlinx.android.synthetic.main.category_title_list.view.*

class CategoryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(str: Pair<String, List<String>>) = with(view) {

        categoryGroupRecyclerView.adapter = CategoryListAdapter(str.second)
        categoryGroupRecyclerView.layoutManager = LinearLayoutManager(view.context)

        titleCheckbox.text = str.first
        setOnClickListener {
            titleCheckbox.isChecked = !titleCheckbox.isChecked
        }
    }

}