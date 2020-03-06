package com.android.upworktracker.bottom_sheet.category.inner_list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.android.upworktracker.entity.Description
import kotlinx.android.synthetic.main.checkbox_item.view.*

class CategoryListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(s: Description) = with(itemView) {
        checkbox.text = s.subtitle
        checkbox.isChecked = s.checkedState
    }
}