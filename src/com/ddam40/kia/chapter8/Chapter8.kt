package com.ddam40.kia.chapter8

import java.lang.StringBuilder

val sum = {x: Int, y: Int -> x + y}
val action = {println("Hello")}
val sum2: (x:Int, y:Int) -> Int = {x, y -> x + y}
val action2: () -> Unit = { println("Hello") }

var canReturnNull: (Int, Int) -> Int? = {x, y -> null}
var funOrNull: ((Int, Int) -> Int)? = null

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(3, 4)
    println("The result is $result")
}

fun mainx() {

    println("${sum2(3, 2)}")
    twoAndThree {x, y -> x+y}

    println("HelLo".filter {it in 'A'..'Z'})

    println(listOf("James", "Tomas", "Jihae").joinToString2() {it.toUpperCase()})
    println(listOf("James", "Tomas", "Jihae").joinToString2(transformer = {it -> it.toLowerCase()}))
}

fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for(c in toCharArray()) {
        if(predicate(c)) {
            sb.append(c)
        }
    }
    return sb.toString()
}

fun <T> Collection<T>.joinToString2(separator: String = ", ", prefix: String = "", postFix: String = "", transformer: ((T) -> String)? = {it.toString()}):  String {
    val sb = StringBuilder(prefix)
    for((index, value) in this.withIndex()) {
        if(index > 0) sb.append(separator)
        sb.append(transformer?.invoke(value) ?: value.toString())
    }
    return sb.append(postFix).toString()
}

enum class Delivery { STANDARD, EXPEDITED }

class Order(val itemCount: Int)

fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double = when(delivery) {
        Delivery.STANDARD -> {order -> 3.1 * order.itemCount}
        else -> {order -> 1.1 * order.itemCount}
    }

fun main() {
    val calculator = getShippingCostCalculator(Delivery.STANDARD)

    println("Price : ${calculator(Order(5))}")
    println("Price : ${getShippingCostCalculator(Delivery.EXPEDITED).invoke(Order(5))}")
    println("Price : ${getShippingCostCalculator(Delivery.EXPEDITED)(Order(5))}")

    val contacts = listOf(Person("James", "Dean", "343-2323"), Person("Svelt", "Isakov", null))
    val contactListFilters = ContactListFilters()
    contactListFilters.apply {
        prefix = "Ja"
        onlyWithPhoneNumber = true
    }
    println(contacts.filter(contactListFilters.getPredicate()))
}

data class Person(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String?
)

class ContactListFilters {
    var prefix: String = ""
    var onlyWithPhoneNumber = false
    fun getPredicate(): (Person) -> Boolean {
        val startsWithPrefix = {p:Person ->
            p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix)
        }
        if(!onlyWithPhoneNumber) {
            return startsWithPrefix
        } else {
            return {startsWithPrefix(it) && it.phoneNumber != null}
        }
    }
}
