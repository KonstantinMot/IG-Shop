package com.ig81.igshop.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.ig81.igshop.ui.screens.achievements.AchievementsScreen
import com.ig81.igshop.ui.screens.car.page.CarPageScreen
import com.ig81.igshop.ui.screens.home.HomeScreen
import com.ig81.igshop.ui.screens.search.SearchScreen

@Composable
fun NavHostScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavScreen.Home) {
        composable<NavScreen.Home> { HomeScreen(navController = navController) }
        composable<NavScreen.Search> {

            SearchScreen(navController = navController,) }
        composable<NavScreen.Achievements> { AchievementsScreen(navController = navController) }
        composable<NavScreen.CarPage> { backStackEntry ->
            val car: NavScreen.CarPage = backStackEntry.toRoute()
           CarPageScreen(navController = navController, carName = car.carName)
        }
    }}






