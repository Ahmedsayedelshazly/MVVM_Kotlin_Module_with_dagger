package com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.datasource

import com.example.mvvm_kotlin_module_with_dagger.data.model.universities.UniversitiesModel
import retrofit2.Response

interface UniversitiesRemoteDataSource {
    suspend fun getUniversities(): Response<List<UniversitiesModel>>
}