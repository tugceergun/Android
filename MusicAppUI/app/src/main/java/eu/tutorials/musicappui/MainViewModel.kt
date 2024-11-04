package eu.tutorials.musicappui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _currentScreen: MutableState<Screen> = mutableStateOf(Screen.DrawerScreen.AddAccount)

    //get
    val currentScreen: MutableState<Screen>
        get() = _currentScreen

    //set
    fun setCurrentScreen(screen: Screen){
        _currentScreen.value = screen
    }
}