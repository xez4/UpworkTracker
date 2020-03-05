package com.android.upworktracker.bottom_sheet.filter.inner_list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.android.upworktracker.entity.Type
import kotlinx.android.synthetic.main.checkbox_item.view.*


class FilterListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(s: String) = with(itemView) {
        checkbox.text = s

        setOnClickListener {
            checkbox.isChecked = !checkbox.isChecked
        }
    }

}

