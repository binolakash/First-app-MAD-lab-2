package com.example.inheritance

class Offspring : Secondary() ,Archery,Singer {
    override fun archery() {
        super.archery()
        println("Archery skills enhanced by Offspring")
    }

    override fun sing() {
        super.sing()
        println("Singing skills enchanced by Offspring")
    }
}