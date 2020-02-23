package com.ddam40.kia.domain

import com.ddam40.kia.lastChar as last
import java.lang.StringBuilder

class KotlinUtil {
    @JvmOverloads
    fun <T> joinToString(collection: Collection<T>, separator: String = ",", prefix: String = "[", postfix: String = "]"): String {
        val result = StringBuilder(prefix)
        for((index, element) in collection.withIndex()) {
            if(index > 0) result.append(separator)
            result.append(element)
        }
        result.append(postfix)
        return result.toString()
    }

    fun main(args: Array<String>) {
        println("LADMD".last())

        val list = listOf("A", "B", "C")
        println(list.joinToString())
    }
}