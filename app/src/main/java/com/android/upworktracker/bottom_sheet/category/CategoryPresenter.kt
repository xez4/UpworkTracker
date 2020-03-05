package com.android.upworktracker.bottom_sheet.category

import com.android.upworktracker.entity.Category
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.MvpPresenter

class CategoryPresenter(private val repo: CategoryRepo) :
    MvpPresenter<CategoryView>() {

    private val categoryAdapter = CategoryAdapter()

    fun getDataFromRepo() {
        val bag = repo.getCategoryList()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { loadData(it) },
                { it.printStackTrace() }
            )
    }

    private fun loadData(item: List<Category>) {
        viewState.initAdapter(categoryAdapter)
        categoryAdapter.setData(item.toMutableList())
    }

}