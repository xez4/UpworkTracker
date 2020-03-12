package com.android.upworktracker.bottom_sheet.category

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.upworktracker.R
import com.android.upworktracker.bottom_sheet.BaseBottomSheetFragment
import kotlinx.android.synthetic.main.category_list.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.get

class CategoryBottomSheetFragment : BaseBottomSheetFragment(), CategoryView {

    @InjectPresenter
    lateinit var categoryPresenter: CategoryPresenter

    @ProvidePresenter
    fun provideCategoryPresenter() = get<CategoryPresenter>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryPresenter.getDataFromRepo()
    }

    override fun initAdapter(adapter: CategoryAdapter) {
        categoryListRecyclerView.adapter = adapter
        categoryListRecyclerView.layoutManager = LinearLayoutManager(context)
    }

   override fun clearCheckboxes() {
        categoryPresenter.clearCheckboxes()
    }

    override fun getLayoutResId() = R.layout.category_list

}