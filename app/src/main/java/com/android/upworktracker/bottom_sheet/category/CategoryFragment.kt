package com.android.upworktracker.bottom_sheet.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.upworktracker.R
import kotlinx.android.synthetic.main.category_list.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.get

class CategoryFragment : MvpAppCompatFragment(), CategoryView {

    @InjectPresenter
    lateinit var categoryPresenter: CategoryPresenter

    @ProvidePresenter
    fun provideCategoryPresenter() = get<CategoryPresenter>()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.category_list, container, false)
    }

    companion object {
        fun newInstance() =
                CategoryFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        categoryPresenter.loadCategoryData()
        categoryPresenter.getDataFromRepo()
    }


    override fun initAdapter(adapter: CategoryAdapter) {
        categoryListRecyclerView.adapter = adapter
        categoryListRecyclerView.layoutManager = LinearLayoutManager(context)
    }

    fun clearCheckboxes(){
        categoryPresenter.clearCheckboxes()
    }

}