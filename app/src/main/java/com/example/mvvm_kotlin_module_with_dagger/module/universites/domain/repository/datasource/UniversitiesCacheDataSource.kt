package com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.datasource

import com.example.mvvm_kotlin_module_with_dagger.data.model.universities.UniversitiesModel

interface UniversitiesCacheDataSource {
    suspend fun getUniversitiesFromCache():List<UniversitiesModel>
    suspend fun saveUniversitiesToCache(universities : List<UniversitiesModel>)
}