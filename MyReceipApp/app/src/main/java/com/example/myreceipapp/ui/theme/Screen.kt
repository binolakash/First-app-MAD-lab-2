package com.example.myreceipapp.ui.theme

sealed class Screen(val route:String) {
    object ReceipeScreen:Screen(route="receipescreen")
    object DetailScreen:Screen(route="detailscreen")
}