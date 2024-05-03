package com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository

import com.example.mvvm_kotlin_module_with_dagger.data.model.universities.UniversitiesModel

interface UniversitiesRepository {

    suspend fun getUniversities():List<UniversitiesModel>?
    suspend fun updateUniversities():List<UniversitiesModel>?
}