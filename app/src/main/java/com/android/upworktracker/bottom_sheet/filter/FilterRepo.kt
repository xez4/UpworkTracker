package com.android.upworktracker.bottom_sheet.filter

import com.android.upworktracker.entity.Filter
import io.reactivex.Single

interface FilterRepo {
    fun getFilterList(): Single<List<Filter>>
}