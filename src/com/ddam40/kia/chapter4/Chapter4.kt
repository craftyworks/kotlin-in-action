package com.ddam40.kia.chapter4

class User private constructor(val nickname: String) {
    companion object {
        fun newUser(email: String) = User(email)
    }
}

interface JSONFactory<T> {
    fun fromJSON(jsonText: String): T
}

class Person(val name: String) {
    companion object: JSONFactory<Person> {
        override fun fromJSON(jsonText: String): Person {
            return Person("json")
        }
    }
}

fun <T> loadFromJSON(factory: JSONFactory<T>): T {
    return factory.fromJSON("json")
}

fun Person.Companion.loadFromJSON(jsonText: String): Person {
    return fromJSON(jsonText)
}
fun main(arg: Array<String>) {
    val user = User.newUser("www@sss.com")
    println("User : ${user.nickname}")

    val person: Person = Person.Companion.fromJSON("json")
    val person2 = Person.fromJSON("json")
    loadFromJSON(Person)

    val o2 = object : JSONFactory<Person> {
        override fun fromJSON(jsonText: String): Person {
            return Person("test")
        }
    }
    val o3 = object : JSONFactory<Person> {
        override fun fromJSON(jsonText: String): Person {
            return Person("test")
        }
    }
    println("${o2.javaClass} ${o3.javaClass}")
}
