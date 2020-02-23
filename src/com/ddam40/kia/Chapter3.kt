package com.ddam40.kia

import java.lang.StringBuilder

var nameOfClass: String = ""

val NAME_OF_CLASS: String = "ABC"


fun main(args: Array<String>) {
    val set = hashSetOf<Int>(1, 7, 53)
    println("$set")


    val list = arrayListOf<Int>(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    println(list)

    println(list.javaClass)

    println(set.javaClass)

    println(map.javaClass)

    val strings = listOf("first", "second", "third")
    println(strings.last())

    val numbers = setOf(1, 4, 2)
    val list2 = arrayListOf(3, 4, 1)

    println(numbers.max())

    println(joinToString(list, ":", "[", "]"))
    println(joinToString(list, separator = ":", postfix = "]", prefix = "["))
    println(joinToString(list))
    println(joinToString(list, postfix = ")"))


    println("Kotlin".lastChar())
}

fun <T> joinToString(collection: Collection<T>, separator: String = ",", prefix: String = "[", postfix: String = "]"): String {
    val result = StringBuilder(prefix)
    for((index, element) in collection.withIndex()) {
        if(index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}