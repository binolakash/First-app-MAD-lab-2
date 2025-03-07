package com.example.mywishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mywishlistapp.data.Graph
import com.example.mywishlistapp.data.Wish
import com.example.mywishlistapp.data.Wishrepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishrepository: Wishrepository= Graph.wishrepository
):ViewModel() {

    var wishTitleState by mutableStateOf(value="")
    var wishDescriptionState by mutableStateOf(value="")

    fun onWishTitleChanged(newString: String){
        wishTitleState = newString
    }

    fun onWishDescriptionChanged(newString: String){
        wishDescriptionState = newString
    }

    lateinit var getAllWishes: Flow<List<Wish>>

    init {
        viewModelScope.launch {
            getAllWishes = wishrepository.getWishes()
        }
    }

    fun addWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishrepository.addWish(wish = wish)
        }
    }

    fun getAWishById(id:Long):Flow<Wish>{
        return wishrepository.getWishById(id)
    }

    fun updateWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishrepository.updateWish(wish = wish)
        }
    }

    fun deleteWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO){
            wishrepository.deleteWish(wish = wish)
        }
    }
}