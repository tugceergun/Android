package eu.tutorials.mywishlistapp

//navigation screen
//sealed -> inherit edilemez.
sealed class Screen(val route:String) {
    object HomeScreen: Screen("home_screen")
    object AddScreen: Screen("add_screen")
}