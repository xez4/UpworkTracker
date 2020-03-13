package com.android.upworktracker.adverts

import android.content.SharedPreferences
import com.android.upworktracker.R
import com.android.upworktracker.bottom_sheet.Repository
import com.android.upworktracker.entity.TrackerRequest
import com.android.upworktracker.entity.TrackerResponse
import com.android.upworktracker.network.services.UpworkService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import moxy.MvpPresenter

class AdvertPresenter(
        private val upworkService: UpworkService,
        private val sharedPreferences: SharedPreferences,
        private val repo: Repository
) : MvpPresenter<AdvertView>() {

    private val compositeDisposable = CompositeDisposable()

    private val advertAdapter = AdvertAdapter()

    fun getDataToRepoFromAPI() {
        repo.getFilterList()
        repo.getCategoryList()
    }

    fun getAdvert() {
        val disposable =
            upworkService.post(TrackerRequest())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        loadData(it)
                        viewState.hideProgress()
                        viewState.enableFilterButton()
                    },
                    { it.printStackTrace() }
                )

        compositeDisposable.add(disposable)
    }



    fun isFirstRun() {
        val isFirstRun =
            sharedPreferences.getBoolean("isFirstRun", true)
        if (isFirstRun) {
            viewState.finishAdvertActivity()
        }
    }

    private fun loadData(item: MutableList<TrackerResponse>) {
        viewState.initAdapter(advertAdapter)
        advertAdapter.setData(item)
    }

    private val advertLinkCallback = object : AdvertCallback{

        override fun advertOnClickListener(link: String) {
            viewState.openLink(link)
        }
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        advertAdapter.advertCallback = advertLinkCallback
    }

    fun notifyOptionsItemSelected(itemId: Int) {
        with(viewState) {
            when (itemId) {
                R.id.refresh -> refresh()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

}