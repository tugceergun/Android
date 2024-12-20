package eu.tutorials.mywishlistapp

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import eu.tutorials.mywishlistapp.data.DummyWishList
import eu.tutorials.mywishlistapp.data.Wish


@Composable
fun HomeView(
    navController: NavController,
    viewModel: WishViewModel
) {

    val context = LocalContext.current
    //now we can use AppBarView.
    Scaffold(
        topBar = { AppBarView(title = "WishList", {

           Toast.makeText(context, "ButtonClicked", Toast.LENGTH_LONG).show()
        })},
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(all = 20.dp),
                contentColor = Color.White,
                //backgroundColor = Color.Black,
                onClick = {
                    //TODO add Navigation to add screen
                    Toast.makeText(context, "FAButtonClicked", Toast.LENGTH_LONG).show()
                    navController.navigate(Screen.AddScreen.route + "/0L") // 0L (id'yi de aliyoruz)
                }) {
                Icon(imageVector = Icons.Default.Add , contentDescription = null)
            }
        }

    ) {
        //display wishes
        val wishList = viewModel.getAllWishes.collectAsState(initial = listOf())
        //collect all wishes put into wishList(viewModel sayesinde)
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(it)){
            items(wishList.value){
                wish ->

                WishItem(wish = wish) {
                    //wish id
                    val id = wish.id
                navController.navigate(Screen.AddScreen.route + "/$id")
            }
            }
        }
    }
}

//Wish-> data class
//WishItem Card'ı olusturuyoruz.
@Composable
fun WishItem(wish: Wish, onClick: () -> Unit){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp, start = 8.dp, end = 8.dp)
        .clickable {
            onClick()
        },
        //elevation = 10.dp,
        //backgroundColor= Color.White
    ){
        Column(modifier = Modifier.padding(16.dp)){
            Text(text = wish.title, fontWeight = FontWeight.ExtraBold) //ustte bold yazi
            Text(text = wish.description)
        }
    }
}