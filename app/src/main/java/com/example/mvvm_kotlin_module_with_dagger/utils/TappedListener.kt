package com.example.mvvm_kotlin_module_with_dagger.utils

interface TappedListener {
    interface DefaultListener {
        fun <T> onItemTapped(t: T?, type: Int, position: Int?)
    }
}