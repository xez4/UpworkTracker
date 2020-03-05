package com.android.upworktracker.bottom_sheet.filter

import com.android.upworktracker.entity.Filter
import com.android.upworktracker.network.services.RepositoryService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.MvpPresenter

class FilterPresenter(
    private val repositoryService: RepositoryService,
    private val repo: FilterRepo
) : MvpPresenter<FilterView>() {

    private val filterList = mutableListOf<Filter>()
    private val filterAdapter = FilterAdapter()

//    fun loadFilterData() {
//        val bag = repositoryService.getRepositoryData()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        {
//                            loadData(it.filter)
//                        },
//                        { it.printStackTrace() }
//                )
//    }

    fun getDataFromRepo() {
        repo.getFilterList()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { loadData(it) },
                {}
            )
    }

    private fun loadData(item: List<Filter>) {
        viewState.initAdapter(filterAdapter)
        filterList.addAll(item.toMutableList())
        filterAdapter.setData(filterList)
    }

    fun clearCheckboxes(){
        for (filter in filterList)
            for (filter_item in filter.type)
                filter_item.checkedState = false
        filterAdapter.notifyDataSetChanged()
    }
}