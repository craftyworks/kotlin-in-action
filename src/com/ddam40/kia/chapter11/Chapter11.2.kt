package com.ddam40.kia.chapter11

import java.lang.AssertionError
import java.time.LocalDate
import java.time.Period

interface Matcher<T> {
    fun test(value: T)
}
class startWith(val prefix: String) : Matcher<String> {
    override fun test(value: String) {
        if(!value.startsWith(prefix))
            throw AssertionError("String $value does not start with $prefix")
    }
}

infix fun <T> T.should(matcher: Matcher<T>) = matcher.test(this)

fun main() {
    "Kotlin" should start with("K")
    "Kotlin".should(start).with("K")

    println(1.days.ago)
    println(1.days.fromNow)
}

val Int.days: Period
    get() = Period.ofDays(this)

val Period.ago: LocalDate
    get() = LocalDate.now() - this

val Period.fromNow: LocalDate
    get() = LocalDate.now() + this

object start

infix fun String.should(x: start): StartWrapper = StartWrapper(this)

class StartWrapper(val value: String) {
    infix fun with(prefix: String) =
        if(!value.startsWith(prefix))
            throw AssertionError("String does not start wiith $prefix : $value")
        else
            Unit
}