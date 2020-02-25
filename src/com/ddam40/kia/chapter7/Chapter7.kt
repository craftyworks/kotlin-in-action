package com.ddam40.kia.chapter7

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

operator fun Point.times(scale: Double) = Point((x * scale).toInt(), (y * scale).toInt())

operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}

fun main() {
    val p0 = Point(3, 3)
    val p1 = Point(4, 4)

    val p2 = p0.plus(p1)
    val p3 = p0 + p1

    println("point : $p2, $p3")

    println("point * 3 = ${p0 * 3.0}")

    println('a' * 5)

    println(5 * 'a')
}

private operator fun Int.times(c: Char): String {
    return c.toString().repeat(this)
}

