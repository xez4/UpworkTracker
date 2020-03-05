package com.android.upworktracker.bottom_sheet

import com.android.upworktracker.entity.Category
import com.android.upworktracker.entity.Filter

interface Repository {
    //    fun getCategoryList(): Single<List<Category>>
    //    fun getFilterList(): Single<List<Filter>>
    fun getCategoryList()
    fun getFilterList()
    fun getFilterContent(): MutableList<Filter>
    fun getCategoryContent(): MutableList<Category>
}