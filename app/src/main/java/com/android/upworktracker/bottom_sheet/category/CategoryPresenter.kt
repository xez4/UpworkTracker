package com.android.upworktracker.bottom_sheet.category

import android.util.Log
import com.android.upworktracker.entity.Category
import com.android.upworktracker.network.services.RepositoryService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.MvpPresenter

class CategoryPresenter(private val repositoryService: RepositoryService) : MvpPresenter<CategoryView>() {

    private val categoryAdapter = CategoryAdapter()

    fun loadBData() { // FIXME
        val bag = repositoryService.getRepositoryData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            loadData(it.category)
                            Log.e("wwww", it.category.toString())
                        },
                        { it.printStackTrace() }
                )
    }

    private fun loadData(item: MutableList<Category>) {
        viewState.initAdapter(categoryAdapter)
        categoryAdapter.setData(item)
    }

}