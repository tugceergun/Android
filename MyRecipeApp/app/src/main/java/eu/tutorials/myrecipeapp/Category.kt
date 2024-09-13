package eu.tutorials.myrecipeapp

//category objects. data model
data class Category(val idCategory:String,
    val strCategory:String,
    val strCategoryThumb:String,
    val strCategoryDescription:String
)

data class CategoriesResponse(val categories: List<Category>)  //categories: json listesinin adi.

