package com.android.upworktracker.category_filter

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.category_item.view.*

class CategoryViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    fun bind(str: String) {
        view.textView.text = str

        view.setOnClickListener {
//            if (view.textView.currentTextColor == Color.parseColor("#000000")){
//                view.textView.setTextColor(Color.parseColor("#6FA850"))
//                view.lineView.visibility = View.VISIBLE
//            }
//            else{
//                view.textView.setTextColor(Color.parseColor("#000000"))
//                view.lineView.visibility = View.GONE
//            }

            view.checkbox.isChecked = !view.checkbox.isChecked

        }
    }
}