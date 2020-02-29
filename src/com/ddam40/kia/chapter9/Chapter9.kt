package com.ddam40.kia.chapter9

import java.lang.IllegalArgumentException
import javax.annotation.processing.ProcessingEnvironment

val <T> List<T>.penultimate: T
    get() = if(size > 1) this[size-2] else throw IllegalArgumentException("size at least 2")

fun main() {
    val l = listOf("James", "Dean")

    println(l.penultimate)

    println(oneHalf(3))
}

interface LList<T> {
    operator fun get(index: Int) : T
}

class StringList: LList<String> {
    override fun get(index: Int): String = "S"
}

fun <T: Number> oneHalf(value: T): Double {
    return value.toDouble() / 2
}

class Processor<T: Any> {
    fun process(value: T) {
        value.hashCode()
    }
}

val nullableT = Processor<String>()
val notnullableT = Processor<String>()
