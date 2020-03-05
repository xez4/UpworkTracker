package com.android.upworktracker.bottom_sheet.category

import com.android.upworktracker.entity.Category
import com.android.upworktracker.network.services.RepositoryService
import io.reactivex.Single

class CategoryRepoImpl(private val repositoryService: RepositoryService) : CategoryRepo {
    override fun getCategoryList(): Single<List<Category>> =
        repositoryService.getRepositoryData().map { it.category }
}