package com.ddam40.kia.chapter7

import java.lang.IllegalArgumentException

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    operator fun unaryMinus() = Point(-x, -y)
}

operator fun Point.times(scale: Double) = Point((x * scale).toInt(), (y * scale).toInt())

operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}

fun main2() {
    val p0 = Point(3, 3)
    val p1 = Point(4, 4)

    val p2 = p0.plus(p1)
    val p3 = p0 + p1

    println("point : $p2, $p3")

    println("point * 3 = ${p0 * 3.0}")

    println("-point = ${-p0}")

    println('a' * 5)

    println(5 * 'a')

    val numbers = ArrayList<Int>()
    numbers += 23
    println("num1 : ${numbers.hashCode()}")
    numbers += 25
    println("num2 : ${numbers.hashCode()}")

    val numbers2 = numbers + 5
    println(numbers.toString())
    println(numbers2.toString())
}

private operator fun Int.times(c: Char): String {
    return c.toString().repeat(this)
}

class Person(val firstName: String, val lastName: String) : Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other, Person::firstName, Person::lastName)
    }
}

fun main() {
    val p = Person("james", "dean")
    val q = Person("alpha", "bet")
    println(p > q)

    val p0 = Point(4, 6)
    println("${p0[0]}, ${p0[1]}")
    println("${p0['x']}")
}

operator fun Point.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else -> throw IllegalArgumentException("Invalid coordinate $index")
    }
}

operator fun Point.get(char: Char) = when (char) {
    'x' -> x
    'y' -> y
    else -> throw IllegalArgumentException("Invalid coordinate $char")
}
