package com.example.mywishlistapp.data

import android.content.Context
import androidx.room.Room

object Graph {
    lateinit var database: Wishdatabase

    val wishrepository by lazy{
        Wishrepository(wishDao = database.wishDao())
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(context, Wishdatabase::class.java, name="wishlist.db").build()
    }
}