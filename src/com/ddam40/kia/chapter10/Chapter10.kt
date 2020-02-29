package com.ddam40.kia.chapter10

import kotlin.reflect.KClass

@Target(AnnotationTarget.PROPERTY)
annotation class JsonExclude

annotation class JsonName(val name: String)

annotation class DeserializeInterface(val targetClass: KClass<out Any>)

interface ValueSerializer<T> {
    fun toJsonValue(value: T): Any?
    fun fromJsonValue(jsonValue: Any?): T
}

annotation class CustomSerializer(val targetClass: KClass<out ValueSerializer<*>>)
