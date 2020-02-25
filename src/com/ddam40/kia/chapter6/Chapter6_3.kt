package com.ddam40.kia.chapter6

import java.io.File

fun main() {
/*
    val list = mutableListOf(1, 2, 3)
    val list2 = listOf(1, 2, 3)
    val list3:MutableList<Int> = list2 as MutableList<Int>

    println("${list.javaClass} and ${list2.javaClass} and ${list3.javaClass}")

    list3[0] = 99
    println(list3)
*/
    val args = arrayOf("A", "B", "C", "D")
    handle(args)
}

class FileIndexer: FileContentProcessor {
    override fun processContents(path: File, binaryContents: ByteArray?, textContents: List<String>?) {

    }
}

fun handle(args: Array<String>) {
    for(i in args) {
        println("i=$i")
    }
    for(i in args.indices) {
        println("i=$i ${args[i]}")
    }
    val alphabets = Array<String>(26) {i -> ('a' + i).toString()}
    println("${alphabets.joinToString()}")
}
