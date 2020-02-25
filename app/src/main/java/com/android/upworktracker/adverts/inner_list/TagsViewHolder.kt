package com.android.upworktracker.adverts.inner_list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tag_advert.view.*

class TagsViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    internal fun bind(data: String?) {
        data.let {
            itemView.tagAdvertText.text = decode(data)
        }
    }

    private fun decode(str: String?) =
        str?.let {
            it.replace("&amp;amp;", "&")
                .replace("&amp;", "&")
                .replace("&quot;", " \" ")
                .replace("&apos;", "\'")
                .replace("&lt;", "<")
                .replace("&gt;", ">")
                .replace("#039;","\'")
                .replace("&rsquo;", "’")
                .replace("&lsquo;", "‘")
                .replace("#8217;", "’")
        }

}