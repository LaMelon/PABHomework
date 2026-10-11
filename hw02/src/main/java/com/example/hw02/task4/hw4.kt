package com.example.hw02.task4

fun calculateStudyMinutes(sessions: Int, minutesPerSession: Int): Int {
    return sessions * minutesPerSession
}
fun calculateTotalCredits(courses: Int, creditsPerCourse: Int): Int {
    return courses * creditsPerCourse
}
fun main() {
    // Part A
    val total1 = calculateStudyMinutes(3, 25)
    println("Total study time: $total1 minutes")
    val total2 = calculateStudyMinutes(4, 30)
    println("Total study time: $total2 minutes")
    println()
    // Part B
    for (i in 1..5) {
        val credits = calculateTotalCredits(i, 3)
        println("Courses: $i, total credits: $credits")
    }
}