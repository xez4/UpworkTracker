package com.android.upworktracker.bottom_sheet.filter

import com.android.upworktracker.bottom_sheet.Repository
import com.android.upworktracker.entity.Filter
import com.android.upworktracker.entity.TrackerRequest
import com.android.upworktracker.network.services.UpworkService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.MvpPresenter

class FilterPresenter(
    private val repo: Repository,
    private val upworkService: UpworkService
) : MvpPresenter<FilterView>() {

    private val filterList = mutableListOf<Filter>()
    private val filterAdapter = FilterAdapter()

    fun getDataFromRepo() {
        loadData(repo.filterContentList)
    }

    private fun loadData(item: List<Filter>) {
        viewState.initAdapter(filterAdapter)
        filterList.addAll(item.toMutableList())
        for (filter in filterList)
            filter.type[0].checkedState = true

        filterAdapter.setData(filterList)
    }

    fun trackRequest() {
        upworkService.post(TrackerRequest())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { },
                { it.printStackTrace() }
            )
    }

    fun clearCheckboxes() {
        filterList.map { it.type.mapIndexed { index, type -> type.checkedState = index == 0 } }
        filterAdapter.notifyDataSetChanged()
    }

}