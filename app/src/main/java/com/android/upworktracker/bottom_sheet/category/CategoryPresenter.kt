package com.android.upworktracker.bottom_sheet.category

import com.android.upworktracker.bottom_sheet.Repository
import com.android.upworktracker.entity.Category
import moxy.MvpPresenter

class CategoryPresenter(private val repo: Repository) : MvpPresenter<CategoryView>() {

    private val categoryAdapter = CategoryAdapter()

    fun getDataFromRepo() {
//        val bag = repo.getCategoryList()
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        { loadData(it) },
//                        { it.printStackTrace() }
//                )
        loadData(repo.getCategoryContent())
    }

    private fun loadData(item: List<Category>) {
        viewState.initAdapter(categoryAdapter)
        categoryAdapter.setData(item.toMutableList())
    }

}