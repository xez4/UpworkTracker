package com.android.upworktracker.bottom_sheet.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.upworktracker.R
import com.android.upworktracker.entity.Category

class CategoryAdapter : RecyclerView.Adapter<CategoryViewHolder>() {

    private val category = mutableListOf<Category>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.category_title_list, parent, false)
        )

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(category[position])
    }

    override fun getItemCount(): Int = category.size

    fun setData(items: MutableList<Category>) {
        category.clear()
        category.addAll(items)
        notifyDataSetChanged()
    }

}