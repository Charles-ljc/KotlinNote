package com.kotlin.note.basic.type

import org.junit.Test

/**
 * [Number](https://kotlinlang.org/docs/reference/basic-types.html#numbers)
 */
class NumberLearn {

    /**
     * [Representation](https://kotlinlang.org/docs/reference/basic-types.html#representation)
     */
    @Test
    fun testRepresentation() {
        val a: Int = 100
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a

        val b: Int = 10000
        val boxedB: Int? = b
        val anotherBoxedB: Int? = b

        println(boxedA === anotherBoxedA) // true 三个等号
        println(boxedB === anotherBoxedB) // false 三个等号
        println(boxedB == anotherBoxedB) // true 两个等号
    }

}