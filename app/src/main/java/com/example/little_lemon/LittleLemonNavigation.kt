package com.example.little_lemon

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.csanad.littlelemon.composable.Onboarding
import com.csanad.littlelemon.composable.Profile

@Composable
fun Navigation(navController: NavHostController, prefs: SharedPreferences, database: LittleLemonDatabase) {
    NavHost(
        navController = navController,
        startDestination = (if (prefs.getBoolean("logged", false)) Screens.Home.rout else Screens.Onboarding.rout)
    ) {
        composable(Screens.Onboarding.rout) {
            Onboarding(navController, prefs)
        }
        composable(Screens.Home.rout) {
            Home(navController, database)
        }
        composable(Screens.Profile.rout) {
            Profile(navController, prefs)
        }
    }
}