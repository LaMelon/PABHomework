package com.example.hw05.task1

fun main() {
    val doubleNum: (Int) -> Int = { it * 2 }
    println(doubleNum(7))

    val startsWithVowel: (String) -> Boolean = { str ->
        if (str.isEmpty()) false
        else "aeiouAEIOU".contains(str[0])
    }
    println(startsWithVowel("apple"))
    println(startsWithVowel("Banana"))
    println(startsWithVowel("orange"))

    val maxInt: (Int, Int) -> Int = { a, b -> if (a > b) a else b }
    println(maxInt(12, 7))
}