package com.example.mvvm_kotlin_module_with_dagger.core_di

import com.example.mvvm_kotlin_module_with_dagger.data.api.ApiService
import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.datasource.UniversitiesRemoteDataSource
import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.datasourceImpl.UniversitiesRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideUniversitiesRemoteDataSource(appService: ApiService): UniversitiesRemoteDataSource {
        return UniversitiesRemoteDataSourceImpl(appService)
    }

}