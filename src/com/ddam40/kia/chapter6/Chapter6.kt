package com.ddam40.kia.chapter6

import java.lang.IllegalArgumentException

fun strLen(s: String?): Int = s?.length ?: 0

class Employee(val name: String, val manager: Employee?)


class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)

class Company(val name: String, val address: Address?)

class Person(val name: String, val company: Company?)

fun Person.countryName(): String = this.company?.address?.country ?: "Unknown"

fun printShippingLabel(person: Person) {
    val address = person.company?.address ?: throw IllegalArgumentException("No address")
    address.apply {
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}

class Manager(val firstName: String, val lastName: String) {
    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? Manager ?: return false
        return otherPerson.firstName == firstName && otherPerson.lastName == lastName
    }

    override fun hashCode(): Int {
        return firstName.hashCode() * 37 + lastName.hashCode()
    }
}
fun notNullLength(str: String) {
    println(str.length)
}
fun main(args: Array<String>) {
    val p1 = Manager("James", "Dean")
    val p2 = Manager("James", "Dean")

    println(p1 == p2)

    println(p1.equals(23))

    val s: String? = null
    s?.apply {
        notNullLength(this)
    }
}
