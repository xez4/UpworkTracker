package com.android.upworktracker.adverts

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.upworktracker.R
import com.android.upworktracker.bottom_sheet.BottomSheetFragment
import com.android.upworktracker.entity.TrackerRequest
import com.android.upworktracker.intro.IntroActivity
import kotlinx.android.synthetic.main.activity_advert.*
import kotlinx.android.synthetic.main.toolbar.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.get

class AdvertActivity : MvpAppCompatActivity(), AdvertView {

    @InjectPresenter
    lateinit var advertPresenter: AdvertPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_advert)

        filterButton.visibility = View.INVISIBLE

        advertPresenter.isFirstRun()
        setToolbar()
        recyclerAdvertsCards.setItemViewCacheSize(TrackerRequest().paging.substringAfter('B').toInt())

        hideProgressBarOnScroll()
        refresh()
        filterButton.setOnClickListener {
            if (!bottomSheet.isAdded) {
                bottomSheet.show(supportFragmentManager, "TAG")
            } else {
                bottomSheet.dialog?.show()
            }
        }

    }

    @ProvidePresenter
    fun provideAdvertsPresenter() = get<AdvertPresenter>()

    private val bottomSheet = BottomSheetFragment()

    override fun onResume() {
        super.onResume()
        bottomSheet.dialog?.hide()
    }

    override fun hideProgressBarOnScroll() {
        recyclerAdvertsCards.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                hideProgress()
            }
        })
    }

    override fun openLink(link: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(link)))
    }

    override fun hideProgress() {
        horizontalProgressBar.let {
            horizontalProgressBar.visibility = ProgressBar.INVISIBLE
        }
    }

    override fun refresh() {
        horizontalProgressBar.visibility = ProgressBar.VISIBLE
        advertPresenter.getAdvert()

    }

    override fun finishAdvertActivity() {
        startActivity(Intent(this, IntroActivity::class.java))
        finish()
    }

    override fun enableFilterButton() {
        filterButton.visibility = View.VISIBLE
    }

    override fun setToolbar() {
        setSupportActionBar(appbarMaterialToolbar)
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