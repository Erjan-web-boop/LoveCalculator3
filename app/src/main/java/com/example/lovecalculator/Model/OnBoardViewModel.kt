package com.example.lovecalculator.Model

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    companion object {
        private const val ONBOARDING_COMPLETED = "onboarding_completed"
    }

    fun isOnboardingCompleted(): Boolean {
        return sharedPreferences.getBoolean(ONBOARDING_COMPLETED, false)
    }

    fun setOnboardingCompleted() {
        sharedPreferences.edit().putBoolean(ONBOARDING_COMPLETED, true).apply()
    }

}
