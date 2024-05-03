package com.example.mvvm_kotlin_module_with_dagger.core_di

import android.app.Application
import androidx.room.Room
import com.example.mvvm_kotlin_module_with_dagger.data.db.AppDataBase
import com.example.mvvm_kotlin_module_with_dagger.data.db.UniversitiesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Singleton
    @Provides
    fun provideUniversitiesDataBase(app: Application):AppDataBase{
        return Room.databaseBuilder(app,AppDataBase::class.java,"app_client")
            .fallbackToDestructiveMigration()
            .build()
    }
    @Singleton
    @Provides
    fun provideUniversitiesDao(appDataBase: AppDataBase): UniversitiesDao {
        return appDataBase.universitiesDao()
    }

}