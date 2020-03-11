package com.android.upworktracker.bottom_sheet.filter.inner_list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.android.upworktracker.entity.Type
import kotlinx.android.synthetic.main.checkbox_item.view.*
import kotlinx.android.synthetic.main.radio_button_item.view.*

class FilterListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(type: Type) = with(itemView) {
        radioButton.text = type.name
        radioButton.isChecked = type.checkedState
    }

}