package com.ddam40.kia.chapter9

import java.lang.IllegalArgumentException
import java.util.*
import javax.print.attribute.standard.Destination
import javax.xml.ws.Service

val list1: List<String> = listOf("A", "B")
val list2: List<Int> = listOf(1, 2, 3)

fun mainx() {
    if(list1 is List<*>) {
        println("List<String>")
    }

    printSum(setOf(1, 2, 3))
}
inline fun <reified T> isA(value: Any) = value is T

fun printSum(c: Collection<Int>) {
    if(c is List<Int>) {
        println(c.sum())
    }

    println(isA<String>("abc"))
    println(isA<Int>("abc"))

    val serviceImpl = loadService<Service>()
    val srv = ServiceLoader.load(Service::class.java)
    println(serviceImpl)
    println(srv)
}

inline fun <reified T> loadService(): ServiceLoader<T>? {
    return ServiceLoader.load(T::class.java)
}

fun addAnswer(list: List<Any>) {
    list.joinToString()
}

fun main() {
    val strings = mutableListOf("a", "b", "c")
    addAnswer(strings)
    val list: MutableList<in Number> = mutableListOf()
    list.add(3)

    copyData(mutableListOf(1, 2, 3), mutableListOf<Any>())
}
fun <T> copyData(source: List<T>, destination: MutableList<in T>) {
   for(item in source) {
       destination.add(item)
   }
}
open class Animal {
    fun feed() {}
}
class Cat: Animal() {
    fun cleanLitter() {}
}
class Herd<out T: Animal>(vararg animals: T) {
    val list = listOf<T>(*animals)
    val size: Int get() = list.size
    operator fun get(i: Int): T = list[i]
}
fun feedAll(animals: Herd<Animal>) {
    for(i in 0 until animals.size) {
        animals[i].feed()
    }
}
fun takeCareOfCats(cats: Herd<Cat>) {
    for(i in 0 until cats.size) {
        cats[i].cleanLitter()
        feedAll(cats)
    }
}