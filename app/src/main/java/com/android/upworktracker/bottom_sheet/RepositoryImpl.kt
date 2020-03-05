package com.android.upworktracker.bottom_sheet

import com.android.upworktracker.entity.Category
import com.android.upworktracker.entity.Filter
import com.android.upworktracker.network.services.RepositoryService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RepositoryImpl(private val repositoryService: RepositoryService) : Repository {

    private lateinit var filterContentList: MutableList<Filter>
    private lateinit var categoryContentList: MutableList<Category>

    override fun getFilterList() {
        val bag = repositoryService.getRepositoryData().map { it.filter }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ filterContentList = it }, {})
    }

    override fun getFilterContent() = filterContentList

    override fun getCategoryContent() = categoryContentList

    override fun getCategoryList() {
        val bag = repositoryService.getRepositoryData().map { it.category }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ categoryContentList = it }, {})
    }
}