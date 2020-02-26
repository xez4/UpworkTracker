package com.android.upworktracker.bottom_sheet_filter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.radio_button.view.*

class RadioViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    fun bind(str: String){
        view.textView.text = str

        view.setOnClickListener {
            view.radioButton.isChecked = !view.radioButton.isChecked
        }
    }

}