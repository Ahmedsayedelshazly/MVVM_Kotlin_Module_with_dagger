package com.example.mvvm_kotlin_module_with_dagger.core_di

import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.UniversitiesRepository
import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.usecases.GetUniversitiesUseCase
import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.usecases.UpdateUniversitiesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    fun provideGetUniversitiesUseCase(universitiesRepository: UniversitiesRepository): GetUniversitiesUseCase {
        return GetUniversitiesUseCase(universitiesRepository)
    }

    @Provides
    fun provideUpdateUniversitiesUseCase(universitiesRepository: UniversitiesRepository): UpdateUniversitiesUseCase {
        return UpdateUniversitiesUseCase(universitiesRepository)
    }

}