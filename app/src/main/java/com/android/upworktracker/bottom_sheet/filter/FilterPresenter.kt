package com.android.upworktracker.bottom_sheet.filter

import android.content.SharedPreferences
import android.util.Log
import com.android.upworktracker.bottom_sheet.Repository
import com.android.upworktracker.entity.Filter
import com.android.upworktracker.entity.TrackerPushRequest
import com.android.upworktracker.network.services.PushService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.MvpPresenter

class FilterPresenter(
        private val repo: Repository,
        private val sharedPreferences: SharedPreferences,
        private val pushService: PushService
) : MvpPresenter<FilterView>() {

    private val filterList = mutableListOf<Filter>()
    private val filterAdapter = FilterAdapter()

    fun getDataFromRepo() {
        loadData(repo.filterContentList)
    }

    private fun getFirebaseToken(): String? =
            sharedPreferences.getString("fcmToken", "hello")

    private fun radioCheckState() =
            filterList.flatMap { it.type.filter { it.checkedState }.map { it.serverName } }

    private fun loadData(item: List<Filter>) {
        viewState.initAdapter(filterAdapter)
        filterList.addAll(item.toMutableList())
        for (filter in filterList)
            filter.type[0].checkedState = true

        filterAdapter.setData(filterList)
    }

    fun trackRequest() {
        val (sortingBy, jobType, experienceLvl, clientHistory, numberOfPropsals, budget, clientInfo, workload, duration) = radioCheckState()
        val disposableBag =
                pushService.postPush(
                                TrackerPushRequest(
                                        sort = sortingBy,
                                        deviceToken = getFirebaseToken(),
                                        budget = budget,
                                        jobType = jobType,
                                        contractorTier = experienceLvl,
                                        workload = workload,
                                        clientHires = clientHistory,
                                        proposals = numberOfPropsals,
                                        verifiedPaymentOnly = clientInfo,
                                        durationV3 = duration
                                )
                        )
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                {
                                    Log.e("FilterPresenter", "On success trackRequest()")
                                    Log.e("FilterPresenter", getFirebaseToken().toString())
                                    Log.e("checkcheck", "${radioCheckState()}")
                                },
                                { it.printStackTrace() }
                        )
    }

    fun clearCheckboxes() {
        filterList.map {
            it.type.mapIndexed { index, type ->
                type.checkedState = index == 0
            }
        }
        filterAdapter.notifyDataSetChanged()
    }

}

private operator fun <E> List<E>.component6() = this[5]
private operator fun <E> List<E>.component7() = this[6]
private operator fun <E> List<E>.component8() = this[7]
private operator fun <E> List<E>.component9() = this[8]