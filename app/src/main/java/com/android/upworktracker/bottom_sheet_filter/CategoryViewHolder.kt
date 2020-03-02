package com.android.upworktracker.bottom_sheet_filter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.category_item.view.*

class CategoryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(str: String) {
        view.textView.text = str

        view.setOnClickListener {

            view.checkbox.isChecked = !view.checkbox.isChecked

        }
    }

}