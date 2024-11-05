package eu.tutorials.musicappui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import eu.tutorials.musicappui.MainViewModel
import eu.tutorials.musicappui.Screen
import eu.tutorials.musicappui.screensInDrawer
import eu.tutorials.musicappui.ui.theme.AccountDialog
import eu.tutorials.musicappui.ui.theme.AccountView
import eu.tutorials.musicappui.ui.theme.Subscription
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(){

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()
    //viewModel
    val viewModel: MainViewModel = viewModel()

    //allow us to find out on which "view" we current are (which screen)
    val controller: NavController = rememberNavController()
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    //dialog open or not
    val dialogOpen = remember{
        mutableStateOf(false)
    }

    //use viewModel
    val currentScreen = remember{
        viewModel.currentScreen.value
    }

    //we can use currentScreen for the remember title
    val title = remember{
        //change that currentScreen.title
        mutableStateOf(currentScreen.title) //now title is dynamic
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(title.value) }, //current screen title
                navigationIcon = { IconButton(onClick = {
                    //Open the drawer
                    scope.launch {
                        scaffoldState.drawerState.open() //drawerState -> drawer açmak icin property
                    }

                }) {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Menu")
                }}

            )
        },scaffoldState = scaffoldState,
        drawerContent = {
            LazyColumn(Modifier.padding(16.dp)){
                items(screensInDrawer){
                    item -> 
                    DrawerItem(selected = currentRoute == item.dRoute, item = item) {
                        scope.launch {
                            scaffoldState.drawerState.close() // when we close the drawer
                        }
                        if(item.dRoute == "add_account") {
                            //open dialog
                            dialogOpen.value= true
                        }else{
                                controller.navigate(item.route)
                            title.value = item.dTtile // navigate the other page and set title
                        }
                    }
                }
            }
        }

    ) {
        //Text("Text", modifier = Modifier.padding(it))
        Navigation(navController = controller, viewModel = viewModel, pd = it)
        
        AccountDialog(dialogOpen = dialogOpen)
    }

}

@Composable
fun DrawerItem(
    selected: Boolean,
    item: Screen.DrawerScreen,
    onDrawerItemClicked: () -> Unit
){
    val background = if (selected) Color.DarkGray else Color.White
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 16.dp)
            .background(background)
            .clickable {
                onDrawerItemClicked()
            }){
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = item.dTtile,
            Modifier.padding(end = 9.dp, top = 4.dp)
        )
        Text(
            text = item.dTtile,
            style= MaterialTheme.typography.titleMedium,
        )
    }

}

@Composable
fun Navigation(navController: NavController, viewModel: MainViewModel, pd: PaddingValues){

    NavHost(navController = navController as NavHostController,
        startDestination = Screen.DrawerScreen.Account.route, modifier = Modifier.padding(pd) //default route
    ){
            composable(Screen.DrawerScreen.Account.route){
                AccountView()
            }
            composable(Screen.DrawerScreen.Subscription.route){
                Subscription()
            }
        }

}