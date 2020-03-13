package com.android.upworktracker.bottom_sheet.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.upworktracker.R
import com.android.upworktracker.bottom_sheet.category.inner_list.CategoryListAdapter
import com.android.upworktracker.entity.Category
import kotlinx.android.synthetic.main.category_title_list.view.*

class CategoryAdapter : RecyclerView.Adapter<CategoryViewHolder>() {

    private val categories = mutableListOf<Category>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.category_title_list, parent, false)
        )

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category)
        with(holder.itemView) {

            val categoryList = category.description
            val categoryListAdapter =
                CategoryListAdapter(categoryList, category, this@CategoryAdapter)
            categoryGroupRecyclerView.adapter = categoryListAdapter
            categoryGroupRecyclerView.layoutManager = LinearLayoutManager(context)

            titleCheckbox.setOnClickListener {
                category.checkedState = !category.checkedState

                for (c in categoryList)
                    c.checkedState = category.checkedState
                categoryListAdapter.notifyDataSetChanged()

            }
        }
    }

    override fun getItemCount(): Int = categories.size

    fun setData(items: MutableList<Category>) {
        categories.clear()
        categories.addAll(items)
        notifyDataSetChanged()
    }

}