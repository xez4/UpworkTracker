package com.android.upworktracker.adverts

import android.util.Log
import com.android.upworktracker.R
import com.android.upworktracker.entity.TrackerRequest
import com.android.upworktracker.entity.TrackerResponse
import com.android.upworktracker.network.services.UpworkService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class AdvertPresenter(private val upworkService: UpworkService) : MvpPresenter<AdvertView>() {

    private val advertAdapter = AdvertAdapter()

    fun getAdvert() {
        val disposable =
            upworkService.post(TrackerRequest())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    loadData(it)
                    Log.e("response", it.first().toString())
                },
                    { Log.e("response", "unluko") }
                )
    }

    private fun loadData(item: MutableList<TrackerResponse>) {
        viewState.initAdapter(advertAdapter)
        advertAdapter.setData(item)
    }

    fun notifyOptionsItemSelected(itemId: Int) {
        with(viewState) {
            when (itemId) {
                R.id.refresh -> refresh()
            }
        }
    }
}
