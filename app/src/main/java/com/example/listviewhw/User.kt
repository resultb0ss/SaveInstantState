package com.example.listviewhw

class User(private val name: String, private val age: Int){

    override fun toString(): String {

        return "Имя: $name Возраст: $age"
    }
}