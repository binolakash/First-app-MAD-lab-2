package com.example.musicappui

import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.grid.GridCells

@Composable
fun BrowseScreen(){
            val cat1 = listOf("1","2","3","4","5","6")
    LazyVerticalGrid(GridCells.Fixed(2)) {
        items(categories){
            BrowseItem(cat = "cat", drawable = R.drawable.baseline_person_add_alt_1_24)
        }
    }
}

@Composable
fun BrowseItem(cat: String, drawable: Int) {
    TODO("Not yet implemented")
}

