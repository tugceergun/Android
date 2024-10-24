package eu.tutorials.mywishlistapp

import android.content.Context
import androidx.room.Room
import eu.tutorials.mywishlistapp.data.WishDatabase
import eu.tutorials.mywishlistapp.data.WishRepository

//db'i kullanabilmek icin.
object Graph {
    lateinit var database: WishDatabase

    //lazy -> sadece gerekli oldugunda calisir.
    val wishRepository by lazy{
        WishRepository(wishDao = database.wishDao())
    }

    //initialize db.
    fun provide(context: Context){
        database = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }
}