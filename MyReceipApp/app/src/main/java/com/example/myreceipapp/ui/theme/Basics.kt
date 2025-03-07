package com.example.myreceipapp.ui.theme

fun main(){

    println("Please enter a number")
    try {
        val number = readln().toInt()
        println("User entered $number")
    }catch(e:Exception){
        println("Error ${e.message}")
    }finally{
        println("This will be execute regardles.Error or no error")
    }
}