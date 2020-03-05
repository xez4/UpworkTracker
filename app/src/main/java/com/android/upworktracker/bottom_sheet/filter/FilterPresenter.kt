package com.android.upworktracker.bottom_sheet.filter

import com.android.upworktracker.entity.Filter
import com.android.upworktracker.network.services.RepositoryService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.MvpPresenter

class FilterPresenter(private val repositoryService: RepositoryService) : MvpPresenter<FilterView>() {

    private val filterAdapter = FilterAdapter()

    fun loadFilterData() {
        val bag = repositoryService.getRepositoryData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            loadData(it.filter)
                        },
                        { it.printStackTrace() }
                )
    }

    private fun loadData(item: MutableList<Filter>) {
        viewState.initAdapter(filterAdapter)
        filterAdapter.setData(item)
    }
}