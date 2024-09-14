package eu.tutorials.myrecipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){

    private val _categorieState = mutableStateOf(RecipeState())  //ekranda degisebilir(mutableState)
    val categoriesState: State<RecipeState> = _categorieState  //disa aktarmak icin

    init{
        fetchCategories()
        //MainViewModel yuklendigi anda.
    }

    //kategorileri almak icin
    //Coroutine kullanilarak arka planda calistirilir
    private fun fetchCategories(){
        //launch coroutine(viewModelScope)
        viewModelScope.launch {
            try{
                val response = recipeService.getCategories()
                //recipeService retrofit servis kismini temsil ediyor.
                // servis kismindaki; val recipeService = retrofit.create(ApiService::class.java) bu tanimlama sayesindeApiService icindeki getCategories'e eristik.
                //ApiService icindeki getCategories'e eristik. 

                //basarili sekilde kategori alindi ise state'i guncelle
                _categorieState.value = _categorieState.value.copy(
                    list = response.categories,   //api'den gelen category listesi
                    loading = false, //yuklenme durumu sona erdi
                    error = null    //hata yok
                )

            }catch(e: Exception){

                //hata olustu ise state'i hata mesaji ile guncelle
                _categorieState.value = _categorieState.value.copy(
                    loading = false,
                    error = "Error fetching Categories ${e.message}"
                )
            }
        }
    }

    //if there is loading or not, category list, and errors (ui states)
    data class RecipeState(
        val loading: Boolean=true,
        val list: List<Category> = emptyList(),
        val error: String? = null
    )
}