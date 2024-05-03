package com.example.mvvm_kotlin_module_with_dagger.core_di

import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.UniversitiesRepository
import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.UniversitiesRepositoryImpl
import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.datasource.UniversitiesCacheDataSource
import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.datasource.UniversitiesLocalDataSource
import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.datasource.UniversitiesRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUniversitiesRepository(
        universitiesRemoteDatasource: UniversitiesRemoteDataSource,
        universitiesLocalDataSource: UniversitiesLocalDataSource,
        universitiesCacheDataSource: UniversitiesCacheDataSource
    ): UniversitiesRepository {

        return UniversitiesRepositoryImpl(
            universitiesRemoteDatasource,
            universitiesLocalDataSource,
            universitiesCacheDataSource
        )
    }
}