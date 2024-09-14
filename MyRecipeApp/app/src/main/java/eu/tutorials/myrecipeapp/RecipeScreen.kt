package eu.tutorials.myrecipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeScreen(modifier: Modifier = Modifier){
    val recipeViewModel: MainViewModel = viewModel() //loading MainViewModel
    val viewstate by recipeViewModel.categoriesState //category state at viewModel
    Box(modifier=Modifier.fillMaxSize()){
        when{
            viewstate.loading -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
                //yukleniyor ifadesi
            }

            viewstate.error != null ->{
                Text("ERROR OCURRED")
            }
            else ->{
                //Display categories
                CategoryScreen(categories = viewstate.list)

            }
        }
    }
}

@Composable
fun CategoryScreen(categories:List<Category>){
    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize()){

        //kategorileri sirayla gridde gosterme.
        items(categories){
            category -> 
            CategoryItem(category = category) //Her kategori icin CategoryItem bileseni cagirilir.
        }
    }
}

//How each item looks like
@Composable
fun CategoryItem(category: Category){
    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally)
    {

        //Category resmi. coil kutuphanesi ile url'den resim yukleme.
        Image(
            painter= rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f) //resmin en boy orani.
        )

        Text(
            text=category.strCategory, //category name
            color= Color.Black,
            style= TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top=4.dp)

        )
    }
}

