package com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.datasourceImpl

import com.example.mvvm_kotlin_module_with_dagger.data.api.ApiService
import com.example.mvvm_kotlin_module_with_dagger.data.model.universities.UniversitiesModel
import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.datasource.UniversitiesRemoteDataSource
import retrofit2.Response

class UniversitiesRemoteDataSourceImpl(
    private val apiService: ApiService
) : UniversitiesRemoteDataSource {
    private val country = "United Arab Emirates"
    override suspend fun getUniversities(): Response<List<UniversitiesModel>> =

        apiService.getUniversities(country)

}