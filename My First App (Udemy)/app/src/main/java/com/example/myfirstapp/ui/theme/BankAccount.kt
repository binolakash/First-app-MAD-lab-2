package com.example.myfirstapp.ui.theme

class BankAccount(var accountHolder:String,var balance:Double){

    val transactionHistory = mutableListOf<String>()

    fun acctBalance():Double{
       return balance
    }

    fun deposit(amount:Double){
        balance += amount
        println("$accountHolder deposits $$amount.")
    }

    fun withdraw(amount:Double){
       if(amount <= balance){
           balance -= amount
           println("$accountHolder withdraw $$amount")
       }else{
           println("Sorry,your balance is unsufficient!")
       }
    }

    fun displayBalance(){
        println("Transaction history for $accountHolder")
        for(transaction in transactionHistory){
            println(transaction)
        }
        println()
        println("The total balance of $accountHolder is $$balance")

    }



}