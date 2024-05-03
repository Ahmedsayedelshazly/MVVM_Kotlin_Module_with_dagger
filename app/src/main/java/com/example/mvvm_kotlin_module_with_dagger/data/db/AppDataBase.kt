package com.example.mvvm_kotlin_module_with_dagger.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mvvm_kotlin_module_with_dagger.data.model.universities.UniversitiesModel
import com.example.mvvm_kotlin_module_with_dagger.utils.StringListConverter

@Database(
    entities = [UniversitiesModel::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(StringListConverter::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun universitiesDao(): UniversitiesDao
}