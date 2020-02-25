package com.ddam40.kia.chapter5

import java.lang.StringBuilder

fun alphabet(): String {
    return StringBuilder().apply {
        for (ch in 'A'..'Z') {
            append(ch)
        }
    }.toString()
}

fun main(args: Array<String>) {
    println(alphabet())
    println("abc".apply { toUpperCase() })
}
