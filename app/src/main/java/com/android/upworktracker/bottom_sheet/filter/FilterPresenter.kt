package com.android.upworktracker.bottom_sheet.filter

import com.android.upworktracker.bottom_sheet.Repository
import com.android.upworktracker.entity.Filter
import moxy.MvpPresenter

class FilterPresenter(private val repo: Repository) : MvpPresenter<FilterView>() {

    private val filterAdapter = FilterAdapter()

    fun getDataFromRepo() {
//        repo.getFilterList()
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        { loadData(it) },
//                        {}
//                )
        loadData(repo.getFilterContent())
    }

    private fun loadData(item: List<Filter>) {
        viewState.initAdapter(filterAdapter)
        filterAdapter.setData(item.toMutableList())
    }
}