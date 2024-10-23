package eu.tutorials.mywishlistapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

//database olusturuyoruz.
@Database(
    entities = [Wish::class], //wish entities
    version = 1,              //first database
    exportSchema = false
)

abstract class WishDatabase: RoomDatabase() {
    abstract fun wishDao(): WishDao
}