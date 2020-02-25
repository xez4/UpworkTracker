package com.android.upworktracker.adverts

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.upworktracker.R
import kotlinx.android.synthetic.main.activity_advert.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.get

class AdvertActivity : MvpAppCompatActivity(), AdvertView {

    @InjectPresenter
    lateinit var advertPresenter: AdvertPresenter

    @ProvidePresenter
    fun provideAdvertsPresenter() = get<AdvertPresenter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        advertPresenter.isFirstRun()
        setContentView(R.layout.activity_advert)
        setToolbar()
        refresh()
    }

    override fun refresh() {
        advertPresenter.getAdvert()
    }

    override fun finishAdvertActivity() {
        finish()
    }

    override fun setToolbar() {
        setSupportActionBar(toolbar)
        title = ""
    }

    override fun initAdapter(advertAdapter: AdvertAdapter) {
        recyclerAdvertsCards.layoutManager = LinearLayoutManager(this)
        recyclerAdvertsCards.adapter = advertAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        advertPresenter.notifyOptionsItemSelected(item.itemId)
        return true
    }

}