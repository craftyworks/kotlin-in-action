package com.ddam40.kia.chapter7

import java.time.LocalDate
import java.util.function.Consumer

data class MutablePoint(var x: Int, var y: Int) {
    operator fun set(index: Int, value: Int) {
        when(index) {
            0 -> x = value
            else -> y = value
        }
    }
    operator fun set(x: Int, y: Int, value: Int) {
        this.x = value
        this.y = value
    }
    operator fun component3() : Int = 5
}

fun main() {
    val p = MutablePoint(3, 3)
    p[0] = 4
    p[1] = 5
    println("Point : $p")
    p[1, 3] = 8
    println("Point : $p")
    println(3 in 1..3)
    println(3 in 1 until 3)

    val (x, y, z) = p
    println("$x, $y, $z")
    val list = listOf(1, 2, 3)
    println("list = $list")
    var (a, b, c, d, e ) = list

    println("$a, $e")
    return

    val region = Rectangle(Point(0, 10), Point(10, 0))
    println(Point(3, 3) in region)
    println(Point(0, 11) in region)

    val newYear = LocalDate.ofYearDay(2020, 1)
    println("newYear : $newYear")
    val daysOff = newYear.minusDays(1) .. newYear

    for(d in daysOff) {
        println("date: $d")
    }
    for(d in daysOff) {
        println("date: $d")
    }
}

operator fun ClosedRange<LocalDate>.iterator() : Iterator<LocalDate> =
    object : Iterator<LocalDate> {
        var current = start

        override fun hasNext(): Boolean = current <= endInclusive

        override fun next(): LocalDate = current.apply {
            current = plusDays(1)
        }
    }


data class Rectangle(val upperLeft: Point, val lowerRight: Point)

operator fun Rectangle.contains(p: Point) = p.x in upperLeft.x .. lowerRight.x && p.y in lowerRight.y .. upperLeft.y
