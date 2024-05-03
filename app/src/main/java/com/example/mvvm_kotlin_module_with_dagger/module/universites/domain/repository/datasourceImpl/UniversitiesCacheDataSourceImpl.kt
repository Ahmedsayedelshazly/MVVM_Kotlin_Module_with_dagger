package com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.datasourceImpl

import com.example.mvvm_kotlin_module_with_dagger.data.model.universities.UniversitiesModel
import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.datasource.UniversitiesCacheDataSource


class UniversitiesCacheDataSourceImpl : UniversitiesCacheDataSource {
    private var universitiesList = ArrayList<UniversitiesModel>()

    override suspend fun getUniversitiesFromCache(): List<UniversitiesModel> {
        return universitiesList
    }

    override suspend fun saveUniversitiesToCache(universities: List<UniversitiesModel>) {
        universitiesList.clear()
        universitiesList = ArrayList(universities)
    }

}