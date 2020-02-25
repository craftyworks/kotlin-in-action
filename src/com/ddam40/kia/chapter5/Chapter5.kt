package com.ddam40.kia.chapter5

import java.nio.channels.Selector

data class Person(val name: String, val age: Int)

fun findTheOrdest(people: List<Person>) {
    var oldest: Person = Person("dummy", Int.MIN_VALUE)
    for(p in people) {
        if(p.age > oldest.age) {
            oldest = p
        }
    }
    println("Oldest people : $oldest")
}

val sum = {x:Int, y:Int -> x+y}

fun main(args: Array<String>) {
    val createPerson = ::Person
    val p = createPerson("James", 15)

    fun Person.isAdult() = age > 20
    val predicate = Person::isAdult
    println("Predicate result : ${predicate(p)}")


    val people = listOf(Person("James", 5), Person("Tom", 10), Person("Jane", 3))
    findTheOrdest(people)
    println("Oldest : ${people.maxBy(Person::age)}")
    println("${sum(5,4)}")
    run {println(42)}

    people.maxBy() { t:Person -> t.age}
    people.maxBy {it.age}
    people.maxBy (Person::age)

    println(people.joinToString(separator = ", ") { it.name })

    printMessageWithPrefix(listOf("Hello", "James", "Steve", "Maria"), "sir")

    printProblemCounts(listOf("404", "403", "502", "200", "301"))

    run(::salute)
}

fun salute() = println("salute!")

fun printMessageWithPrefix(message: Collection<String>, prefix: String) {
    message.forEach {
        println("$prefix $it")
    }
}

fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0
    responses.forEach {
        if(it.startsWith("4")) {
            clientErrors++
        } else if(it.startsWith("5")) {
            serverErrors++
        }
    }
    println("$clientErrors client errors, $serverErrors server errors")
}