package com.example.mvvm_kotlin_module_with_dagger.core_di

import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.datasource.UniversitiesCacheDataSource
import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.datasourceImpl.UniversitiesCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CacheDataModule {
    @Singleton
    @Provides
    fun provideUniversitiesCacheDataSource(): UniversitiesCacheDataSource {
        return UniversitiesCacheDataSourceImpl()
    }
}