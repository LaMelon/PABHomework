package com.example.hw05.task2

fun applyTwice(n: Int, operation: (Int) -> Int): Int {
    return operation(operation(n))
}
fun printIf(items: List<String>, condition: (String) -> Boolean) {
    items.filter(condition).forEach { println(it) }
}
fun <T> transform(list: List<T>, mapper: (T) -> String): List<String> {
    return list.map(mapper)
}
fun main() {
    val doubleNum: (Int) -> Int = { it * 2 }
    println(applyTwice(3, doubleNum))

    val courses = listOf("Algorithm", "Android", "Database", "Network", "Algebra")
    val vowelCheck: (String) -> Boolean = { str -> "aeiouAEIOU".contains(str[0]) }
    printIf(courses, vowelCheck)

    val numbers = listOf(2, 3, 4)
    val squaredStrings = transform(numbers) { (it * it).toString() }
    println(squaredStrings) // Expected: [4, 9, 16]
}