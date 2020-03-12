package com.android.upworktracker.bottom_sheet.category

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.upworktracker.bottom_sheet.category.inner_list.CategoryListAdapter
import com.android.upworktracker.entity.Category
import kotlinx.android.synthetic.main.category_title_list.view.*

class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(category: Category) = with(itemView) {

        titleCheckbox.text = category.titleCategory
        titleCheckbox.isChecked = category.checkedState

    }

}