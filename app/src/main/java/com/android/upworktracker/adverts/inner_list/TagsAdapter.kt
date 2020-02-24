package com.android.upworktracker.adverts.inner_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.upworktracker.R

class TagsAdapter(private val tags: MutableList<String>?) : RecyclerView.Adapter<TagsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TagsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.tag_advert,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: TagsViewHolder, position: Int) =
        holder.bind(tags?.get(position))

    override fun getItemCount() = tags?.size?:0

}
