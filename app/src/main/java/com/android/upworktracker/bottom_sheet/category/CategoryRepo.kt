package com.android.upworktracker.bottom_sheet.category

import com.android.upworktracker.entity.Category
import io.reactivex.Single

interface CategoryRepo {
    fun getCategoryList(): Single<List<Category>>
}