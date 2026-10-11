package com.example.hw05.task4

data class Config(var host: String = "", var port: Int = 0, var debug: Boolean = false)

fun main() {
    val config = Config().apply {
        host = "localhost"
        port = 8080
        debug = true
    }
    println(config)

    val name: String? = "Rina"
    name?.let {
        println(it.uppercase())
    }
    val numbers = mutableListOf(1, 2, 3)
    numbers.also {
        println("Before: $it")
        it.add(4)
    }.also {
        println("After: $it")
    }
}