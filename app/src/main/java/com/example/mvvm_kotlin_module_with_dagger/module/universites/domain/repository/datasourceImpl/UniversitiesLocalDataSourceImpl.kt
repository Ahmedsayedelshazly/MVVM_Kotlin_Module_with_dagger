package com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.datasourceImpl

import com.example.mvvm_kotlin_module_with_dagger.data.db.UniversitiesDao
import com.example.mvvm_kotlin_module_with_dagger.data.model.universities.UniversitiesModel
import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.datasource.UniversitiesLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UniversitiesLocalDataSourceImpl(
    private val universitiesDao: UniversitiesDao
) : UniversitiesLocalDataSource {
    override suspend fun getUniversitiesFromDB(): List<UniversitiesModel> {
        return universitiesDao.get()
    }

    override suspend fun saveUniversitiesToDB(universities: List<UniversitiesModel>) {

        CoroutineScope(Dispatchers.IO).launch {
            universitiesDao.save(universities)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            universitiesDao.deleteAll()
        }
    }
}