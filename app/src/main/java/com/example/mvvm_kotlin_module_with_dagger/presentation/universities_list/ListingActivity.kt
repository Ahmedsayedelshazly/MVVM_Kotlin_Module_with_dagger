package com.example.mvvm_kotlin_module_with_dagger.presentation.universities_list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
 import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
 import androidx.lifecycle.ViewModelProvider

import com.example.mvvm_kotlin_module_with_dagger.R
import com.example.mvvm_kotlin_module_with_dagger.data.model.universities.UniversitiesModel
import com.example.mvvm_kotlin_module_with_dagger.databinding.ActivityListingBinding
import com.example.mvvm_kotlin_module_with_dagger.module.universites.viewmodel.UniversitiesViewModel
import com.example.mvvm_kotlin_module_with_dagger.module.universites.viewmodel.UniversitiesViewModelFactory
import com.example.mvvm_kotlin_module_with_dagger.presentation.universities_details.DetailsActivity
import com.example.mvvm_kotlin_module_with_dagger.utils.TappedListener
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListingActivity : AppCompatActivity(), TappedListener.DefaultListener {

    @Inject
    lateinit var factory: UniversitiesViewModelFactory
    private lateinit var viewModel: UniversitiesViewModel
    private lateinit var binding: ActivityListingBinding
    private lateinit var adapter: UniversitiesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_listing)
        viewModel = ViewModelProvider(this, factory).get(UniversitiesViewModel::class.java)

        initRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        displayUniversities()
    }

    private fun initRecyclerView() {
        adapter = UniversitiesAdapter(this)
        binding.recyclerView.adapter = adapter
        val responseLiveData = viewModel.updateUniversities()
        responseLiveData.observe(this, Observer {
            loadData(it)
        })
    }

    private fun displayUniversities() {
        binding.listProgressBar.visibility = View.VISIBLE
        val responseLiveData = viewModel.getUniversities()
        responseLiveData.observe(this, Observer {
            loadData(it)
        })
    }

    private fun loadData(it: List<UniversitiesModel>?) {
        if (it != null) {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
            binding.listProgressBar.visibility = View.GONE
            binding.noDataText.visibility = View.GONE
        } else {
            binding.listProgressBar.visibility = View.GONE
            binding.noDataText.visibility = View.VISIBLE
        }
    }


    override fun <T> onItemTapped(t: T?, type: Int, position: Int?) {
        val item = t as UniversitiesModel
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("item_model", item)
        startActivity(intent)
    }

}