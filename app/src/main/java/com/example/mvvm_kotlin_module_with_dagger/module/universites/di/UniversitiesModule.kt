package com.example.mvvm_kotlin_module_with_dagger.module.universites.di

 import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.usecases.GetUniversitiesUseCase
import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.usecases.UpdateUniversitiesUseCase
import com.example.mvvm_kotlin_module_with_dagger.module.universites.viewmodel.UniversitiesViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class UniversitiesModule {

    @ActivityScoped
    @Provides
    fun provideUniversitiesViewModelFactory(
        getUniversitiesUseCase: GetUniversitiesUseCase,
        updateUniversitiesUseCase: UpdateUniversitiesUseCase
    ): UniversitiesViewModelFactory {
        return UniversitiesViewModelFactory(
            getUniversitiesUseCase,
            updateUniversitiesUseCase
        )
    }
}