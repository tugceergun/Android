package eu.tutorials.mywishlistapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeView() {

    //now we can use AppBarView.
    Scaffold(
        topBar = { AppBarView(title = "WishList")}
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize().padding(it)){

        }
    }
}