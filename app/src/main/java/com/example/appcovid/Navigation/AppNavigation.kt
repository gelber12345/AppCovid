package com.example.appcovid.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.appcovid.Screens.DetalleScreen
import com.example.appcovid.Screens.EventosScreen
import com.example.appcovid.Screens.FirstScreen

@Composable
fun AppNavigation(
    navController: NavHostController
) {
    //val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.FirstScreen.route) {
        composable(
            route = AppScreens.FirstScreen.route
        ) {
            FirstScreen(navController)
        }
        composable(
            route = AppScreens.DetalleScreen.route + "/{text}",
            arguments = listOf(navArgument(name = "text") {
                type = NavType.StringType
            })
        ) {
            DetalleScreen(navController, it.arguments?.getString("text"))
        }
        composable(
            route = AppScreens.EstadisticasScreen.route
        ) {
            EventosScreen(navController)
        }
    }
}