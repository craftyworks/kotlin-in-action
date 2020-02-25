package com.ddam40.kia.chapter6

import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class MyService {
    fun performAction(): String = "foo"
}

class MyTest {
    private lateinit var myService: MyService

    fun setUp() {
        myService = MyService()
    }

    fun testAction() {
        myService.performAction()
    }
}

fun main(args: Array<String>) {
    val p = JavaPerson("James")
    val s: String = p.name
    println("Name : ${p.name.length} NickName : ${p.nickName?.length}")


    val i: Long = 3
    val j: Int = 3
    val k: Int = j
    val ans: Any = 42
    println(ans.javaClass)
    println(ans is JvmType.Object)
    println(test().toString())
}

fun test(): Unit {}

interface Processor<T> {
    fun process() : T
}

class NoResultProcessor : Processor<Unit> {
    override fun process(): Unit {
    }
}

fun fail(message: String) : Nothing {
    throw IllegalArgumentException(message)
}

fun fail2(message: String) {
    throw IllegalArgumentException(message)
}
