package com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository

import android.util.Log
import com.example.mvvm_kotlin_module_with_dagger.data.model.universities.UniversitiesModel
import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.datasource.UniversitiesCacheDataSource
import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.datasource.UniversitiesLocalDataSource
import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.datasource.UniversitiesRemoteDataSource

class UniversitiesRepositoryImpl(
    private val universitiesRemoteDataSource: UniversitiesRemoteDataSource,
    private val universitiesLocalDataSource: UniversitiesLocalDataSource,
    private val universitiesCacheDataSource: UniversitiesCacheDataSource
) : UniversitiesRepository {
    override suspend fun getUniversities(): List<UniversitiesModel>? {
        return getUniversitiesFromCache()
    }


    override suspend fun updateUniversities(): List<UniversitiesModel>? {
        val newListOfUniversities = getUniversitiesFromApi()
        universitiesLocalDataSource.clearAll()
        universitiesLocalDataSource.saveUniversitiesToDB(newListOfUniversities)
        universitiesCacheDataSource.saveUniversitiesToCache(newListOfUniversities)
        return newListOfUniversities
    }

    private suspend fun getUniversitiesFromCache(): List<UniversitiesModel> {
        lateinit var universitiesList: List<UniversitiesModel>
        try {
            universitiesList = universitiesCacheDataSource.getUniversitiesFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        universitiesList= emptyList()
        }
        if (universitiesList.size > 0) {
            return universitiesList
        } else {
            universitiesList = getUniversitiesFromDB()
            universitiesCacheDataSource.saveUniversitiesToCache(universitiesList)
        }

        return universitiesList
    }

    private suspend fun getUniversitiesFromDB(): List<UniversitiesModel> {
        lateinit var universitiesList: List<UniversitiesModel>
        try {
            universitiesList = universitiesLocalDataSource.getUniversitiesFromDB()
        } catch (exception: java.lang.Exception) {
            Log.i("MyTag", exception.message.toString())
            universitiesList = emptyList()
        }
        if (universitiesList.size > 0) {
            return universitiesList
        } else {
            universitiesList = getUniversitiesFromApi()
            universitiesLocalDataSource.saveUniversitiesToDB(universitiesList)
        }
        return universitiesList
    }

    private suspend fun getUniversitiesFromApi(): List<UniversitiesModel> {
        lateinit var universitiesList: List<UniversitiesModel>
        try {
            val response = universitiesRemoteDataSource.getUniversities()
            val body = response.body()
            if (body != null) {
                universitiesList = body
            }
        } catch (exception: java.lang.Exception) {
            Log.i("MyTag", exception.message.toString())
            universitiesList = emptyList()
        }
        return universitiesList
    }
}
