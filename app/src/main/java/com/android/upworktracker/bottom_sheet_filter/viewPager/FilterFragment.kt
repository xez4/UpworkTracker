package com.android.upworktracker.bottom_sheet_filter.viewPager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.upworktracker.R
import com.android.upworktracker.bottom_sheet_filter.RadioAdapter
import kotlinx.android.synthetic.main.filter_list.*

class FilterFragment : Fragment() {

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


        val sortingByData = arrayListOf("Newest", "Relevance", "Client spend", "Client rating")
        val sortingByAdapter = RadioAdapter(sortingByData)

        sortingByRecyclerView.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = sortingByAdapter
        }

        val jobTypeData = arrayListOf("Any Job Type", "Hourly", "Fixed Price")
        val jobTypeAdapter = RadioAdapter(jobTypeData)
        jobTypeRecyclerView.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = jobTypeAdapter
        }

        val experienceLevelData = arrayListOf(
                "Any experience level",
                "Entry Level - $",
                "Intermediate - $$",
                "Master - $$$"
        )

        val experienceLevelAdapter = RadioAdapter(experienceLevelData)
        experienceRecyclerView.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = experienceLevelAdapter
        }

        val clientHistoryData =
                arrayListOf("Any client history", "No hires", "1 to 9 hires", "10+ hires")
        val clientHistoryAdapter = RadioAdapter(clientHistoryData)
        clientHistoryRecyclerView.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = clientHistoryAdapter
        }

        val numberOfProposalsData = arrayListOf(
                "Any Number of Proposals",
                "Less than 5",
                "5 to 10",
                "10 to 15",
                "15 to 20",
                "20 to 50"
        )
        val numberOfProposalsAdapter = RadioAdapter(numberOfProposalsData)
        numberOfProposalsRecyclerView.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = numberOfProposalsAdapter
        }

        val budgetData = arrayListOf(
                "Any Budget",
                "Less than $100",
                "$100 - $500",
                "$500 - $1k",
                "$1k - $5k",
                "$5k+"
        )
        val budgetAdapter = RadioAdapter(budgetData)
        budgetRecyclerView.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = budgetAdapter
        }

        val clientInfoData = arrayListOf("Payment Verified")
        val clientInfoAdapter = RadioAdapter(clientHistoryData)
        clientInfoRecyclerView.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = clientHistoryAdapter
        }

        val hoursPerWeekData =
                arrayListOf("Any Hours Per Week", "Less than 30 hrs/week", "More than 30 hrs/week")
        val hoursPerWeekAdapter = RadioAdapter(hoursPerWeekData)
        hoursPerWeekRecyclerView.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = hoursPerWeekAdapter
        }
    }

}