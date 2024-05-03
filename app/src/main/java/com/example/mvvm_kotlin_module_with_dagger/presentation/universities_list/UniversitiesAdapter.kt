package com.example.mvvm_kotlin_module_with_dagger.presentation.universities_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_kotlin_module_with_dagger.R
import com.example.mvvm_kotlin_module_with_dagger.data.model.universities.UniversitiesModel
import com.example.mvvm_kotlin_module_with_dagger.databinding.ItemUniversityListBinding
import com.example.mvvm_kotlin_module_with_dagger.utils.TappedListener

class UniversitiesAdapter(val listener: TappedListener.DefaultListener) :
    RecyclerView.Adapter<UniversitiesAdapter.ViewHolder>() {
    private val adapterList = ArrayList<UniversitiesModel>()

    fun setList(universities: List<UniversitiesModel>) {
        adapterList.clear()
        adapterList.addAll(universities)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemUniversityListBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_university_list,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return adapterList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(adapterList[position])
    }

    inner class ViewHolder(private val binding: ItemUniversityListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(university: UniversitiesModel) {

            binding.apply {
                name.text = university.name
                state.text = university.state_province
                mainLayout.setOnClickListener {
                    listener.onItemTapped(university, 1, adapterPosition)
                }
            }

        }

    }
}



