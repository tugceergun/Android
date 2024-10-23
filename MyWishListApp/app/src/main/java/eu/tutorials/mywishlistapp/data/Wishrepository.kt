package eu.tutorials.mywishlistapp.data

import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDao: WishDao) {

    //wishDao'daki func'lari cagiriyoruz.
    //repository -> dao ve viewmodel arasında baglanti

    suspend fun addWish(wish:Wish){
        wishDao.addAWish(wish)
    }

    fun getWishes(): Flow<List<Wish>> = wishDao.getAllWishes()

    fun getAWishById(id:Long) : Flow<Wish> {
        return wishDao.getAWisheById(id)
    }

    suspend fun updateAWish(wish: Wish){
        wishDao.updateAWish(wish)
    }

    suspend fun deleteAWish(wish: Wish){
        wishDao.deleteAWish(wish)
    }
}