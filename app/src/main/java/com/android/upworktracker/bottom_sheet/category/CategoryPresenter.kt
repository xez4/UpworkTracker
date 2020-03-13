package com.android.upworktracker.bottom_sheet.category

import com.android.upworktracker.bottom_sheet.Repository
import com.android.upworktracker.entity.Category
import moxy.MvpPresenter

class CategoryPresenter(private val repo: Repository) : MvpPresenter<CategoryView>() {

    private val categoryList = mutableListOf<Category>()
    private val categoryAdapter = CategoryAdapter()

    fun getDataFromRepo() {
        loadData(repo.categoryContentList)
    }

    private fun loadData(item: List<Category>) {
        viewState.initAdapter(categoryAdapter)
        categoryList.addAll(item.toMutableList())
        categoryAdapter.setData(categoryList)
    }

    fun clearCheckboxes() {
        categoryList.map {
            it.checkedState = false
            it.description.map { it.checkedState = false }
        }
        categoryAdapter.notifyDataSetChanged()
    }

}