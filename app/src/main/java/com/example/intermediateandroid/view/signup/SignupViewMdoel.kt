package com.example.intermediateandroid.view.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.intermediateandroid.model.UserModel
import com.example.intermediateandroid.model.UserPreference
import kotlinx.coroutines.launch

class SignupViewModel(private val pref: UserPreference) : ViewModel() {
    fun saveUser(user: UserModel) {
        viewModelScope.launch {
            pref.saveUser(user)
        }
    }
}