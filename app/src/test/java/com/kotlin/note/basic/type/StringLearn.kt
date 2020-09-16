package com.kotlin.note.basic.type

import org.junit.Test

/**
 * [String](https://kotlinlang.org/docs/reference/basic-types.html#strings)
 */
class StringLearn {

    @Test
    fun testCharInString() {
        val str = "string"
        for (c in str) {
            println(c)
        }
    }

    /**
     * [Raw String](https://kotlinlang.org/docs/reference/basic-types.html#string-literals)
     */
    @Test
    fun testRawString() {
        val text = """
            |Tell me and I forget.
            |Teach me and I remember.
            |Involve me and I learn.
            |(Benjamin Franklin)
            """
        println(text)

        println(text.trimMargin()) // 可以通过传参修改分隔符，默认 |
    }

    /**
     * [Show dollar in string templates](https://kotlinlang.org/docs/reference/basic-types.html#string-templates)
     */
    @Test
    fun testDollar() {
        val price = """
            ${'$'}9.99
            """.trim()
        println(price)
    }

}