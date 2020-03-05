package com.android.upworktracker.bottom_sheet.filter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.upworktracker.R
import kotlinx.android.synthetic.main.filter_list.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.get

class FilterFragment : MvpAppCompatFragment(), FilterView {

    @InjectPresenter
    lateinit var filterPresenter: FilterPresenter

    @ProvidePresenter
    fun provideFilterPresenter() = get<FilterPresenter>()

    lateinit var adapter: FilterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.filter_list, container, false)
    }

    companion object {
        fun newInstance() =
            FilterFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        filterPresenter.getDataFromRepo()
    }


    override fun initAdapter(adapter: FilterAdapter) {
        filterListRecyclerView.adapter = adapter
        filterListRecyclerView.layoutManager = LinearLayoutManager(context)
    }

    fun clearCheckboxes(){
        filterPresenter.clearCheckboxes()
    }
}