package com.android.upworktracker.bottom_sheet.filter

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.upworktracker.R
import com.android.upworktracker.bottom_sheet.BaseBottomSheetFragment
import kotlinx.android.synthetic.main.filter_list.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.get

class FilterBottomSheetFragment : BaseBottomSheetFragment(), FilterView {

    @InjectPresenter
    lateinit var filterPresenter: FilterPresenter

    @ProvidePresenter
    fun provideFilterPresenter() = get<FilterPresenter>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        filterPresenter.getDataFromRepo()
        filterListRecyclerView.setItemViewCacheSize(50)
    }

    override fun initAdapter(adapter: FilterAdapter) {
        filterListRecyclerView.adapter = adapter
        filterListRecyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun clearCheckboxes() {
        filterPresenter.clearCheckboxes()
    }

    override fun getLayoutResId() = R.layout.filter_list

}