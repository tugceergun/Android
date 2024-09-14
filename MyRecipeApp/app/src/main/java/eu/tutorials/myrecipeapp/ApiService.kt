package eu.tutorials.myrecipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET


private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val recipeService = retrofit.create(ApiService::class.java)  //ustteki retrofit'in devami gibi. recipeService degiskenine atadik.
//ApiService::class.java --> bu sayede ApiService icindeki metodlara ulasabiliriz. (getCategories'e mesela)

interface ApiService{

    @GET("categories.php")
    suspend fun getCategories():CategoriesResponse // CategoriesResponse dondurur. Yaniti alip Categories listesine koymak.
}