package eu.tutorials.musicappui

import androidx.annotation.DrawableRes

sealed class Screen(val title: String, val route: String) {

    //BottomBar
    sealed class BottomScreen(
        val bTitle: String, val bRoute: String, @DrawableRes val icon: Int
    ):Screen(bTitle,bRoute){
        object Home: BottomScreen("Home", "home",R.drawable.baseline_music_video_24)

        object Library: BottomScreen(
            "Library", "library", R.drawable.baseline_library_music_24
        )

        object Browse: BottomScreen(
           "Browse", "browse", R.drawable.baseline_apps_24
        )
    }



    //Drawer
    sealed class DrawerScreen(val dTtile: String, val dRoute: String, @DrawableRes val icon: Int)
        :Screen(dTtile,dRoute){
            object Account: DrawerScreen(
                "Account",
                "account",
                R.drawable.ic_account //ekledigimiz drawble (tools-> resource manager)
            )
        object Subscription: DrawerScreen(
            "Subsription",
            "subscribe",
            R.drawable.ic_subscribe //ekledigimiz drawble
        )
        object AddAccount: DrawerScreen(
            "Add account",
            "add_account",
            R.drawable.baseline_person_add_alt_1_24 //ekledigimiz drawble
        )

        }
}

val screensInBottom = listOf(
    Screen.BottomScreen.Home,
    Screen.BottomScreen.Browse,
    Screen.BottomScreen.Library
)

val screensInDrawer = listOf(
    Screen.DrawerScreen.Account,
    Screen.DrawerScreen.Subscription,
    Screen.DrawerScreen.AddAccount
)