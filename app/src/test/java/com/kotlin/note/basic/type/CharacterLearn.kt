package com.kotlin.note.basic.type

import org.junit.Test

/**
 * [Character](https://kotlinlang.org/docs/reference/basic-types.html#characters)
 */
class CharacterLearn {

    @Test
    fun testCharToInt() {
        for (c in '0'..'5') {
            val intValue = c.toInt() - '0'.toInt()
            println("char '$c': int value is $intValue")
        }
    }

}