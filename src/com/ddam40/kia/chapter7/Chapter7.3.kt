package com.ddam40.kia.chapter7

class MapPerson {
    private val _attributes = hashMapOf<String, String>()
    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }
    val name: String by _attributes
}

fun main() {
    val p = MapPerson()
    val data = mapOf("name" to "James", "company" to "JetBrains")
    for((attrName, value) in data) {
        p.setAttribute(attrName, value)
    }
    println("P name : ${p.name} length : ${p.name.length}")
}
