package com.example.myfirstapp.ui.theme

fun main(){

     val sarah = BankAccount(accountHolder = "Sarah", balance = 0.0)

    sarah.withdraw(amount = 10.0)
    sarah.deposit(amount = 100.0)
    sarah.deposit(amount = 300.0)
    sarah.displayBalance()


}