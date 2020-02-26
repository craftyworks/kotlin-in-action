package com.ddam40.kia.chapter7

data class Email(val address: String)

data class NewPerson(val name: String) {
    val emails: List<Email> by lazy {loadEmails()}

    private fun loadEmails(): List<Email> {
        println("loading emails")
        return listOf(Email("$name@gmail.com"))
    }
}

fun main() {
    val person = NewPerson("James")
    println("Person : $person")

    println("Person : $person, mail: ${person.emails}")
    println("mail: ${person.emails}")
}