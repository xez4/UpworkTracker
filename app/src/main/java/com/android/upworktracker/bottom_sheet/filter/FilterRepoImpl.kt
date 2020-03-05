package com.android.upworktracker.bottom_sheet.filter

import com.android.upworktracker.entity.Filter
import com.android.upworktracker.network.services.RepositoryService
import io.reactivex.Single

class FilterRepoImpl(private val repositoryService: RepositoryService) : FilterRepo {
    override fun getFilterList(): Single<List<Filter>> =
        repositoryService.getRepositoryData().map { it.filter }
}