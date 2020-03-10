package com.android.upworktracker.bottom_sheet.category.inner_list

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.upworktracker.R
import com.android.upworktracker.bottom_sheet.category.CategoryAdapter
import com.android.upworktracker.entity.Category
import com.android.upworktracker.entity.Description
import kotlinx.android.synthetic.main.checkbox_item.view.*

class CategoryListAdapter(
    private val dataset: List<Description>,
    val categoryTitle: Category,
    val parentAdapter: CategoryAdapter
) : RecyclerView.Adapter<CategoryListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CategoryListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.checkbox_item,
                parent,
                false
            )
        )

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) {
        val category = dataset[position]
        holder.bind(category)
        with(holder.itemView){
            checkbox.setOnClickListener {
                category.checkedState = !category.checkedState
                if (!category.checkedState){
                    categoryTitle.checkedState = false
                    parentAdapter.notifyDataSetChanged()
                }
            }
        }
    }
}