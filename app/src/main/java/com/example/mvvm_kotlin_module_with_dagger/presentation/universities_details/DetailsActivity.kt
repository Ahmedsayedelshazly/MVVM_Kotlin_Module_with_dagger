package com.example.mvvm_kotlin_module_with_dagger.presentation.universities_details

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mvvm_kotlin_module_with_dagger.R
import com.example.mvvm_kotlin_module_with_dagger.data.model.universities.UniversitiesModel
import com.example.mvvm_kotlin_module_with_dagger.databinding.ActivityDetailsBinding
import com.example.mvvm_kotlin_module_with_dagger.databinding.ActivityListingBinding
import com.example.mvvm_kotlin_module_with_dagger.presentation.universities_list.ListingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    private lateinit var item_model: UniversitiesModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        initBinding()
    }

     private fun initBinding() {
        item_model = intent.getSerializableExtra("item_model") as UniversitiesModel

        if (item_model != null) {
            binding.apply {
                name.text = item_model.name
                state.text = item_model.state_province
                country.text = item_model.country
                if (item_model.web_pages != null && item_model.web_pages!!.isNotEmpty())
                    webPage.text = item_model.web_pages!![0].toString()
                loadingImage.setOnClickListener {
                    val intent = Intent(it.context, ListingActivity::class.java)
                    startActivity(intent)
                    finishAffinity()
                }
            }
        }
    }
}