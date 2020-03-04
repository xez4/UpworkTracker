package com.android.upworktracker.bottom_sheet.filter.inner_list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.checkbox_item.view.*

class FilterListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(s: String, check: Boolean = false) = with(itemView) {
        checkbox.text = s
        if (check)
            checkbox.isChecked = true
        setOnClickListener {
            checkbox.isChecked = !checkbox.isChecked
        }
    }
}