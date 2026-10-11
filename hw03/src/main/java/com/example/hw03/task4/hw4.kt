package com.example.hw03.task4

fun showInfo(data: Any) {
    when (data) {
        is String -> println(data.length)
        is Int -> println(data * 2)
        else -> println("Unknown")
    }
}
fun main() {
    showInfo("Kotlin")
    showInfo(10)
    showInfo(true)
}