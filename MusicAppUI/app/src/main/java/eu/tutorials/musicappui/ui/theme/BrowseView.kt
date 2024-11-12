package eu.tutorials.musicappui.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import eu.tutorials.musicappui.R


//Browse screen
@Composable
fun Browse() {

    val categories = listOf("Hits", "Happy", "Workout", "Running", "TGIF", "Yoga")
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {

            items(categories) { cat ->
                BrowserItem(cat = cat, drawable = R.drawable.baseline_apps_24) //HomeView'daki cardlar gibi
            }
        }

}
