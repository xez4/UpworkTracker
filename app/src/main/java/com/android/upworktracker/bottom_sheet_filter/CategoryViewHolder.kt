package com.android.upworktracker.bottom_sheet_filter

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.upworktracker.bottom_sheet_filter.inner_list.CategoryListAdapter
import kotlinx.android.synthetic.main.category_title_list.view.*
import kotlinx.android.synthetic.main.checkbox_item.view.*

class CategoryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(str: Pair<String, List<String>>) = with(view) {

        val categoryListAdapter = CategoryListAdapter(str.second)
        categoryGroupRecyclerView.adapter = categoryListAdapter
        categoryGroupRecyclerView.layoutManager = LinearLayoutManager(view.context)

        titleCheckbox.text = str.first
        titleCheckbox.isChecked = false

        setOnClickListener {
            titleCheckbox.isChecked = !titleCheckbox.isChecked
            categoryListAdapter.checkAll()
        }
    }

}