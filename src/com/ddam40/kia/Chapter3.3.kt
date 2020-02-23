package com.ddam40.kia

import java.lang.StringBuilder

fun String.lastChar(): Char = get(length-1)

fun <T> Collection<T>.joinToString(collection: Collection<T>, separator: String = ",", prefix: String = "[", postfix: String = "]"): String {
    val result = StringBuilder(prefix)
    for((index, element) in collection.withIndex()) {
        if(index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}
fun main(args: Array<String>) {
    println("ABCDEF".lastChar())
    val list = listOf("A", "B", "C")
    println(list.joinToString())

    val view: View = Button()
    view.click()
    view.showOff()
}

open class View {
    open fun click() = println("View clicked")
}

class Button: View() {
    override fun click() = println("Button clicked")
}

fun View.showOff() = println("I'm a View")

fun Button.showOff() = println("I'm a Button")

val String.lastChar: Char
    get() = get(length-1)