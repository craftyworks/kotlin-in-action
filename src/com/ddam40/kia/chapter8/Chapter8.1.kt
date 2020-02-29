package com.ddam40.kia.chapter8

import java.util.concurrent.locks.Lock


enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

data class SiteVisit (
    val path: String,
    val duration: Double,
    val os: OS
)

val log = listOf(
    SiteVisit("/", 34.0, OS.WINDOWS),
    SiteVisit("/", 22.0, OS.MAC),
    SiteVisit("/login", 12.0, OS.WINDOWS),
    SiteVisit("/signup", 8.0, OS.IOS),
    SiteVisit("/", 16.3, OS.ANDROID)
)

val averageWindowsDuration = log.filter { it.os == OS.WINDOWS }.map(SiteVisit::duration).average()

fun List<SiteVisit>.averageDurationFor(os: OS) = filter { it.os == os }.map(SiteVisit::duration).average()
fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) =
    filter(predicate).map(SiteVisit::duration).average()

fun main() {
    println(averageWindowsDuration)
    println(log.averageDurationFor(OS.MAC))
    println(log
        .filter { it.os in setOf(OS.IOS, OS.ANDROID) }
        .map(SiteVisit::duration)
        .average())
    println(log.averageDurationFor { it.os in setOf(OS.IOS, OS.ANDROID) })

    lookForAlice(people)
}

data class ClickPerson(val name: String, val age: Int)

val people = listOf(ClickPerson("Alice", 20), ClickPerson("Bob", 31))

fun lookForAlice(people: List<ClickPerson>) {
    people.forEach(fun (person) {
        if(person.name == "Alice") {
            println("found!")
            return
        }
        println("${person.name} is not Aclice")
    })
}
