package com.example.mvvm_kotlin_module_with_dagger.data.model.universities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "universities")
data class UniversitiesModel(
    val alpha_two_code: String?,
    val country: String?,
    val domains: List<String>?,
    @PrimaryKey
    val name: String,
    @SerializedName("state-province")
    val state_province: String?,
    val web_pages: List<String>?
):Serializable