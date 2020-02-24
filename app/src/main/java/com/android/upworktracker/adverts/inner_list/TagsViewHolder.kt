package com.android.upworktracker.adverts.inner_list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tag_advert.view.*

class TagsViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    internal fun bind(data: String?) {
        data.let {
            itemView.tagAdvertText.text = data
        }
    }

}