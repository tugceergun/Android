package eu.tutorials.myrecipeapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//category objects. data model
@Parcelize
data class Category(val idCategory:String,
    val strCategory:String,
    val strCategoryThumb:String,
    val strCategoryDescription:String): Parcelable


data class CategoriesResponse(val categories: List<Category>)  //categories: json listesinin adi.

