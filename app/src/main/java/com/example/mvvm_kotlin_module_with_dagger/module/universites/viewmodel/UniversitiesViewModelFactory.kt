package com.example.mvvm_kotlin_module_with_dagger.module.universites.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.usecases.GetUniversitiesUseCase
import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.usecases.UpdateUniversitiesUseCase

class UniversitiesViewModelFactory(
    private val getUniversitiesUseCase: GetUniversitiesUseCase,
    private val updateUniversitiesUseCase: UpdateUniversitiesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UniversitiesViewModel(getUniversitiesUseCase, updateUniversitiesUseCase) as T
    }
}