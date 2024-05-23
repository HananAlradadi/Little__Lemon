package com.example.little_lemon

sealed class Screens (val rout : String) {
    data object Onboarding : Screens("Onboarding")
        data object Home : Screens("Home")
        data object Profile : Screens("Profile")
    }