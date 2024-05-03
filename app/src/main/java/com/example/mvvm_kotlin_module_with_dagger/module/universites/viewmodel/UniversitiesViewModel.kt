package com.example.mvvm_kotlin_module_with_dagger.module.universites.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.usecases.GetUniversitiesUseCase
import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.usecases.UpdateUniversitiesUseCase

class UniversitiesViewModel(
    private val getUniversitiesUseCase: GetUniversitiesUseCase,
    private val updateUniversitiesUseCase: UpdateUniversitiesUseCase
) : ViewModel() {

    fun getUniversities() = liveData {
        val universitiesList = getUniversitiesUseCase.execute()
        emit(universitiesList)
    }

    fun updateUniversities() = liveData {
        val universitiesList = updateUniversitiesUseCase.execute()
        emit(universitiesList)
    }
}