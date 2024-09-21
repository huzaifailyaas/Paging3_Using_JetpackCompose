import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.paging3.Navigation.Screen
import com.example.paging3.Screens.HomeScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController, // Corrected from NavController to navController
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController) // Corrected from NavController to navController
        }
        composable(route = Screen.Search.route) {
//            SearchScreen(navController = navController) // Corrected from NavController to navController
        }
    }
}
