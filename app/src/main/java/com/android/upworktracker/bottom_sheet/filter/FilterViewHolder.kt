package com.android.upworktracker.bottom_sheet.filter

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.upworktracker.bottom_sheet.filter.inner_list.FilterListAdapter
import com.android.upworktracker.entity.Filter
import kotlinx.android.synthetic.main.filter_title_list.view.*

class FilterViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

    fun bind(filter: Filter) = with(itemView) {

        val filterListAdapter = FilterListAdapter(filter.type)
        filterGroupRecyclerView.adapter = filterListAdapter
        filterGroupRecyclerView.layoutManager = LinearLayoutManager(context)

        filterTitle.text = filter.titleFilter

//        setOnClickListener {
//            titleCheckbox.isChecked = !titleCheckbox.isChecked
//            filterListAdapter.checkAll()
//        }
    }

}