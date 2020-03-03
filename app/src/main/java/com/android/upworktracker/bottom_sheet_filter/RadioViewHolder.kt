package com.android.upworktracker.bottom_sheet_filter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.checkbox_item.view.*

class RadioViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(str: String) {
        view.checkbox.text = str

        view.setOnClickListener {
            view.checkbox.isChecked = !view.checkbox.isChecked
        }
    }

}