package com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.usecases

import com.example.mvvm_kotlin_module_with_dagger.data.model.universities.UniversitiesModel
import com.example.mvvm_kotlin_module_with_dagger.module.universites.domain.repository.UniversitiesRepository

class UpdateUniversitiesUseCase(private val universitiesRepository: UniversitiesRepository) {
    suspend fun execute(): List<UniversitiesModel>? = universitiesRepository.updateUniversities()
}