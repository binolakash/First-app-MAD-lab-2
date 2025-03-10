package com.example.mywishlistapp.data

import kotlinx.coroutines.flow.Flow

class Wishrepository(private val wishDao:WishDao) {
    suspend fun addWish(wish:Wish){
        wishDao.addWish(wish)
    }

    fun getWishes(): Flow<List<Wish>> = wishDao.getAllWishes()

    fun getWishById(id:Long): Flow<Wish>{
        return wishDao.getAWishById(id)
    }

    suspend fun updateWish(wish: Wish){
        wishDao.updateWish(wish)
    }

    suspend fun deleteWish(wish: Wish){
        wishDao.deleteWish(wish)
    }
}