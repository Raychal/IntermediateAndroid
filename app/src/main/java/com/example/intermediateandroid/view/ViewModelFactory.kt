package com.example.intermediateandroid.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.intermediateandroid.model.UserPreference
import com.example.intermediateandroid.view.login.LoginViewModel
import com.example.intermediateandroid.view.main.MainViewModel
import com.example.intermediateandroid.view.signup.SignupViewModel

class ViewModelFactory(private val pref: UserPreference) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(pref) as T
            }
            modelClass.isAssignableFrom(SignupViewModel::class.java) -> {
                SignupViewModel(pref) as T
            }
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(pref) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}