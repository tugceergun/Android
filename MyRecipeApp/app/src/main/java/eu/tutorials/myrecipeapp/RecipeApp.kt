package eu.tutorials.myrecipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController){
    val recipeViewModel: MainViewModel = viewModel()  //MainViewModel tipinde recipeViewModel olusturduk.
    val viewstate by recipeViewModel.categoriesState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route){
     composable(route= Screen.RecipeScreen.route){
         RecipeScreen(viewstate= viewstate, navigateToDetail = {
             //Bu bolum, mevcut ekrandan details ekranina veri aktarmaktan sorumlu
             navController.currentBackStackEntry?.savedStateHandle?.set("cat",it)
             //Mevcut ekranin backstack girisini alir.//pespese acilan sayfalar gibi(backstack).
             navController.navigate(Screen.DetailScreen.route)
         })
     }

        composable(route = Screen.DetailScreen.route){
            val category = navController.previousBackStackEntry?.savedStateHandle?.
            get<Category>("cat") ?: Category("","","","")
            CategoryDetailScreen(category = category)
        }

    }
}


