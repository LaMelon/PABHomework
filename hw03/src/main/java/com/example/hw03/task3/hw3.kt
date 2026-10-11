package com.example.hw03.task3

fun main() {
    var studentName: String? = "agus"
    println("Length: ${studentName?.length}")
    println("Name: ${studentName ?: "Unknown"}")
    studentName?.let {
        println("Hello, $it!")
    }
}