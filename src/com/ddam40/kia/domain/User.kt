package com.ddam40.kia.domain

import java.lang.IllegalArgumentException

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {

    fun validate(value: String, fieldName: String) {
        if(value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: emptry $fieldName")
        }
    }

    validate(user.name, "Name")
    validate(user.address, "Address")
}

fun main(args: Array<String>) {
    saveUser(User(1, "", ""))
}
