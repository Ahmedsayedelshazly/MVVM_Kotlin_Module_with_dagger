package com.example.mvvm_kotlin_module_with_dagger.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm_kotlin_module_with_dagger.data.model.universities.UniversitiesModel

@Dao
interface UniversitiesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(movies: List<UniversitiesModel>)

    @Query("DELETE FROM universities")
    suspend fun deleteAll()

    @Query("SELECT * FROM universities")
    suspend fun get(): List<UniversitiesModel>
}