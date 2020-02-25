package com.ddam40.kia.chapter5

fun main2(args: Array<String>) {

    val list = listOf(1, 2, 3, 4)
    println(list.filter { it % 2 == 0})
    println(list.map{it * it})
    println(list.map {Person(it.toString(), it)})

    val people = listOf(Person("J", 34), Person("A", 123), Person("JAM", 12))
    println(people.filter { it.age > 30 })
    println(people.map(Person::name))
    println(people.groupBy { it.age })

    println(people.filter { it.age < 30 }.map { it.name })

    val maxAge = people.maxBy(Person::age)!!.age
    people.filter { it.age == maxAge }

    val numbers = mapOf(0 to "zero", 1 to "One", 2 to "Two")
    println(numbers.mapValues { it.value.toUpperCase() })
    println(numbers.mapKeys { it.value })
    println(numbers.map{ it.key })

    println("""
        -----------------
    """.trimIndent())

    println(people.all {it.age > 100})
    val overHundred = {p:Person -> p.age > 100}
    println(people.all(overHundred))

    println(people.any {it.name == "A"})
    println(people.count { it.age < 30})
    println(people.filter { it.age < 30 }.size)
    println(people.find {it.age > 30})

    val list2 = listOf(1, 3, 5, 6, 112)
    println(list2.groupBy { it }.javaClass)
    println(list2.map {it to it}.javaClass)

    val list3 = listOf("a", "abc", "bc", "bcd")
    println(list3.groupBy { it.first() })
}

class Book(val title:String, val author: List<String>)

fun main(args: Array<String>) {
    val books = listOf(Book("Math", listOf("James", "Tom", "Max", "Joh")), Book("Language", listOf("Michael", "Tom", "Max", "유누리")))

    println(books.flatMap{it.author})
    println(books.flatMap{it.author}.toSet())
    println("abc".toList())

    val people = listOf(Person("J", 34), Person("A", 123), Person("JAM", 12))
    println(people.asSequence()
        .map(Person::name)
        .filter { it.startsWith("A")}
        .toList())

    listOf(1, 2, 3, 4)
        .map {print("map($it) "); it * it}
        .filter {print("filter($it) "); it % 2 == 0}
    println()

    println(listOf(1, 2, 3, 4).asSequence().map { it * it}.find {it > 3})

    val naturalNumbers = generateSequence(0) {it + 1}
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())
}
