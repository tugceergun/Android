package eu.tutorials.mywishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//wish hangi properties'leri almali
@Entity(tableName="wish-table") //db wish'leri iceren table'a sahip olacak.
data class Wish(
    @PrimaryKey(autoGenerate = true) // otomatik primaryKey olusturur tablo icin.
    val id: Long = 0L,
    @ColumnInfo(name="wish-title") // column adi.
    val title: String= "",
    @ColumnInfo(name="wish-desc")
    val description: String=""
)

object DummyWishList{
    val wishList= listOf(
        Wish(title= "Google watch 2", description = "An android watch"),
        Wish(title= "Google watch 2", description = "An android watch"),
        Wish(title= "Google watch 2", description = "An android watch"),
        Wish(title= "Google watch 2", description = "An android watch")
    )
}