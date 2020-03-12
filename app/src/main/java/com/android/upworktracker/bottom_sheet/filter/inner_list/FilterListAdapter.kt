package com.android.upworktracker.bottom_sheet.filter.inner_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.upworktracker.R
import com.android.upworktracker.entity.Type
import kotlinx.android.synthetic.main.checkbox_item.view.*
import kotlinx.android.synthetic.main.radio_button_item.view.*


class FilterListAdapter(private val dataset: List<Type>) :
    RecyclerView.Adapter<FilterListViewHolder>() {

    var checkedPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FilterListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.radio_button_item,
                parent,
                false
            )
        )

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: FilterListViewHolder, position: Int) {
        holder.bind(dataset[position])
        with(holder.itemView) {
            radioButton.setOnClickListener {
                dataset[checkedPosition].checkedState = false
                notifyItemChanged(checkedPosition)
                checkedPosition = position
                dataset[position].checkedState = true
            }
        }
    }

}