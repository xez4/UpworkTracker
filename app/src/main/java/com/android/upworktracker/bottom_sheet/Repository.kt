package com.android.upworktracker.bottom_sheet

import com.android.upworktracker.entity.Category
import com.android.upworktracker.entity.Filter
import com.android.upworktracker.network.services.RepositoryService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Repository(private val repositoryService: RepositoryService) {

    lateinit var filterContentList: MutableList<Filter>
    lateinit var categoryContentList: MutableList<Category>

    fun getFilterList() {
        val bag = repositoryService.getRepositoryData().map { it.filter }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ filterContentList = it }, {})
    }

    fun getCategoryList() {
        val bag = repositoryService.getRepositoryData().map { it.category }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ categoryContentList = it }, {})
    }

}