package com.android.upworktracker.bottom_sheet_filter.view_pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.upworktracker.R
import com.android.upworktracker.bottom_sheet_filter.FilterAdapter
import kotlinx.android.synthetic.main.filter_list.*

class FilterFragment : Fragment() {

    lateinit var adapter: FilterAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.filter_list, container, false)
    }

    companion object {
        fun newInstance() = FilterFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = arrayListOf(
            "Soring By" to listOf("Newest", "Relevance", "Client spend", "Client rating"),
            "Job Type" to listOf("Any Job Type", "Hourly", "Fixed Price"),
            "Experience Level" to listOf("Any experience level",
                "Entry Level - $",
                "Intermediate - $$",
                "Master - $$$"),
            "Client History" to listOf("Any client history", "No hires", "1 to 9 hires", "10+ hires"),
            "Number of Proposals" to listOf("Any Number of Proposals",
                "Less than 5",
                "5 to 10",
                "10 to 15",
                "15 to 20",
                "20 to 50"),
            "Budget" to listOf("Any Budget",
                "Less than $100",
                "$100 - $500",
                "$500 - $1k",
                "$1k - $5k",
                "$5k+"),
            "Client Info" to listOf("Payment Verified"),
            "Hours Per Week" to listOf("Any Hours Per Week", "Less than 30 hrs/week", "More than 30 hrs/week"))

        adapter = FilterAdapter(database)

        filterListRecyclerView.adapter = adapter
        filterListRecyclerView.layoutManager = LinearLayoutManager(view.context)
    }

    fun clearCheckboxes() {
//        adapter = FilterAdapter(database)
//        filterListRecyclerView.adapter = adapter
    }

}