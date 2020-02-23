package com.ddam40.kia

fun main(args: Array<String>) {

    val map = mapOf(1 to "one")
    val map2 = mapOf(1.to("one"))

    println("12.345-A.42".split("."))


    val str = """ | //
                . | //
                . | //
    """.trimMargin(".")
    println(str)
}

fun test(vararg args: String) {
    for((idx, str) in args.withIndex()) {
        println("$idx : $str")
    }

}

