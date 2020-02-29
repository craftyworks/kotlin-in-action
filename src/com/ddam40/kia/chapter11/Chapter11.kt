package com.ddam40.kia.chapter11

import java.lang.StringBuilder


fun buildString(builderAction: StringBuilder.() -> Unit): String = StringBuilder().apply(builderAction).toString()

fun main() {
    println(createTable())
}

fun <T> T.apply(block: T.() -> Unit): T {
    block()
    return this
}

fun <T, R> with(receiver: T, block: T.() -> R): R = receiver.block()

open class Tag(val name: String) {
    private val children = mutableListOf<Tag>()
    protected fun <T : Tag> doInit(child: T, init: T.() -> Unit) {
        child.init()
        children.add(child)
    }

    override fun toString() = "<$name>${children.joinToString("")}</$name>"
}

class TABLE : Tag("table") {
    fun tr(init: TR.() -> Unit) = doInit(TR(), init)
}

class TR : Tag("tr") {
    fun td(init: TD.() -> Unit) = doInit(TD(), init)
}

class TD : Tag("td")

fun createTable() =
    table {
        for (i in 1..2) {
            tr {
                td {}
            }
        }
    }

fun table(init: TABLE.() -> Unit): TABLE = TABLE().apply(init)


