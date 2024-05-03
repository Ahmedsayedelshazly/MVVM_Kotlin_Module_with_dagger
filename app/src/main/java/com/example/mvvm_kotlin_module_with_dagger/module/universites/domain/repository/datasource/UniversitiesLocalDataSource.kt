package com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.datasource

import com.example.mvvm_kotlin_module_with_dagger.data.model.universities.UniversitiesModel

interface UniversitiesLocalDataSource {

    suspend fun getUniversitiesFromDB(): List<UniversitiesModel>
    suspend fun saveUniversitiesToDB(universities: List<UniversitiesModel>)
    suspend fun clearAll( )

}