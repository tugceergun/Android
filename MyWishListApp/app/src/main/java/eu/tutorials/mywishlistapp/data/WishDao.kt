package eu.tutorials.mywishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE) //zaten var olan wish ekliyorsak ihnore strategy kullandik.
    abstract suspend fun addWish(wishEntity: Wish) //wishEntity, wish.kt -> entity wih

    //loads all wishes from the wish table
    @Query("Select * from `wish-table`")
    abstract fun getAllWishes(): Flow<List<Wish>> //flow, wishes listesi sondurur

    @Update
    abstract suspend fun updateAWish(wishEntity: Wish)

    @Delete
    abstract suspend fun deleteAWish(wishEntity: Wish)

    @Query("Select * from `wish-table` where id=:id")
    abstract fun getAWisheById(id:Long): Flow<Wish> //flow, sadece bir wish dondurur.
    //flow-> coroutine'leri senkronize eder.
    //zaten flow kullandigi icin yani coroutines kullandigi icin suspend func yapmadik bu fonk'lari.

}