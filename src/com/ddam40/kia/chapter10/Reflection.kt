package com.ddam40.kia.chapter10

import kotlin.reflect.KFunction
import kotlin.reflect.full.memberProperties

class Person(val name: String, val age: Int)

fun main() {
    val person = Person("James", 32)
    val kClass = person.javaClass.kotlin
    println(kClass.simpleName)
    kClass.memberProperties.forEach {println("${it.name} = ${it.call(person)}")}

    val kFunction = ::sum
    kFunction.invoke(3, 4)
    kFunction(3, 4)

    val numberProperty = Person::age
    numberProperty.get(person)
}

fun sum(x: Int, y: Int) = x + y
