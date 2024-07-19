package principal.fraseparastatus.frasesderapparastatus.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import principal.fraseparastatus.frasesderapparastatus.data.Screens
import principal.fraseparastatus.frasesderapparastatus.ui.screens.CategoryScreen
import principal.fraseparastatus.frasesderapparastatus.ui.screens.MainScreen
import principal.fraseparastatus.frasesderapparastatus.ui.screens.SplashScreen


enum class Route{
    SplashRoute,
    MainRoute
}

@Composable
fun AppNavigation(innerPadding: PaddingValues) {
    val navController = rememberNavController()
    NavHost(navController = navController, modifier = Modifier.padding(innerPadding),
        startDestination = Route.SplashRoute.name,
        builder = {
            navigation(startDestination = Screens.SplashScreen.name,route = Route.SplashRoute.name){
                composable(Screens.SplashScreen.name){
                    SplashScreen(navController)
                }
            }

            navigation(startDestination = Screens.MainScreen.name,route = Route.MainRoute.name){
                composable(Screens.MainScreen.name){
                    MainScreen(navController)
                }
                composable(Screens.CategoryScreen.name + "/{name}",
                    arguments = listOf(navArgument(name="name"){type = NavType.StringType})){
                        backStackEntry->
                    CategoryScreen(navController,backStackEntry.arguments?.getString("name"))
                }
           }


        }
    )

}