package com.example.hw05.task3

data class Student(val name: String, val score: Int, val year: Int)

fun main() {
    val students = listOf(
        Student("Ali", 85, 2023),
        Student("Budi", 62, 2022),
        Student("Citra", 91, 2023),
        Student("Dewi", 58, 2022),
        Student("Eka", 76, 2023)
    )
    val passingCount = students.filter { it.score >= 70 }.size
    println(passingCount)

    students.map { "${it.name} (${it.score})" }.forEach { println(it) }
    students.sortedByDescending { it.score }
        .take(3)
        .map { it.name }
        .forEach { println(it) }
    val totalScore = students.fold(0) { acc, student -> acc + student.score }
    val averageScore = totalScore.toDouble() / students.size
    println("Total: $totalScore   Average: $averageScore")

    students.groupBy { it.year }
        .forEach { (year, list) ->
            println("$year: ${list.map { student -> student.name }}")
        }
}