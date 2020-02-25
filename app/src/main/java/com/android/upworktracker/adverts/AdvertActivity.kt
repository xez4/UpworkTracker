package com.android.upworktracker.adverts

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.upworktracker.R
import com.android.upworktracker.intro.IntroActivity
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

        if (Build.VERSION.SDK_INT < 23) {
            window.statusBarColor = Color.BLACK
        }

        isFirstRun()

        setContentView(R.layout.activity_advert)
        setToolbar()
        refresh()
    }

    fun isFirstRun() {
        val isFirstRun =
            getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE).getBoolean("isFirstRun", true)
        if (isFirstRun) {
            startActivity(Intent(this, IntroActivity::class.java))
            finish()
        }
    }

    override fun refresh() {
        advertPresenter.getAdvert()
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