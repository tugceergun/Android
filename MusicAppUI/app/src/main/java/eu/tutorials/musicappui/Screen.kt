package eu.tutorials.musicappui

import androidx.annotation.DrawableRes

sealed class Screen(val title: String, val route: String) {

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