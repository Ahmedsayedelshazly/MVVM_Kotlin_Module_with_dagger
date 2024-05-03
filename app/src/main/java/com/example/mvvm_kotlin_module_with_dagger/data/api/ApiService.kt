package com.example.mvvm_kotlin_module_with_dagger.data.api

import com.example.mvvm_kotlin_module_with_dagger.data.model.universities.UniversitiesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search")
    suspend fun getUniversities(
        @Query("country") country: String,
    ): Response<List<UniversitiesModel>>
}