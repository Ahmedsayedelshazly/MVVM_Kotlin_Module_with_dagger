package com.example.mvvm_kotlin_module_with_dagger.core_di

import com.example.mvvm_kotlin_module_with_dagger.data.db.UniversitiesDao
import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.datasource.UniversitiesLocalDataSource
import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.datasourceImpl.UniversitiesLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideUniversitiesLocalDataSource(universitiesDao: UniversitiesDao): UniversitiesLocalDataSource {
        return UniversitiesLocalDataSourceImpl(universitiesDao)
    }

}