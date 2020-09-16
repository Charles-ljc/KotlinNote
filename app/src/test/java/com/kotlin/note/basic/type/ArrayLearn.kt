package com.kotlin.note.basic.type

import org.junit.Test

/**
 * [Array](https://kotlinlang.org/docs/reference/basic-types.html#arrays)
 */
class ArrayLearn {

    @Test
    fun testArrayConstructor() {
        val asc = Array(5) { i -> (i * i).toString() }
        asc.forEach { println(it) }
    }

}