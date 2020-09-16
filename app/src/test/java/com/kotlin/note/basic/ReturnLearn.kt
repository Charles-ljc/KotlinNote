package com.kotlin.note.basic

import org.junit.Test

/**
 * [Returns and Jumps](https://kotlinlang.org/docs/reference/returns.html)
 */
class ReturnLearn {

    /**
     * [Break and Continue Labels](https://kotlinlang.org/docs/reference/returns.html#break-and-continue-labels)
     */
    @Test
    fun testBreakLabel() {
        println("start")
        loop@ for (i in 1..10) {
            for (j in 1..10) {
                if (j == 3) break@loop
                println("i=$i j=$j")
            }
        }
        println("done break")
    }

    @Test
    fun testContinueLabel() {
        println("start")
        loop@ for (i in 1..10) {
            for (j in 1..10) {
                if (j == 3) continue@loop
                println("i=$i j=$j")
            }
        }
        println("done continue")
    }

    /**
     * [Return at Labels](https://kotlinlang.org/docs/reference/returns.html#return-at-labels)
     */
    @Test
    fun testReturn() {
        println("start")
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return // non-local return directly to the caller of testReturn()
            println(it)
        }
        println("done unreachable") // 不会执行
    }

    @Test
    fun testReturnWithExplicitLabel() {
        println("start")
        listOf(1, 2, 3, 4, 5).forEach lit@{
            if (it == 3) return@lit // local return to the caller of the lambda, i.e. the forEach loop
            println(it)
        }
        println("done with explicit label")
    }

    @Test
    fun testReturnWithImplicitLabel() {
        println("start")
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@forEach // local return to the caller of the lambda, i.e. the forEach loop
            println(it)
        }
        println("done with implicit label")
    }

    @Test
    fun testReturnWithAnonymous() {
        println("start")
        listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
            if (value == 3) return  // local return to the caller of the anonymous fun, i.e. the forEach loop
            println(value)
        })
        println("done with anonymous function")
    }

    @Test
    fun testReturnFromNestedLoop() {
        println("start")
        run loop@{
            listOf(1, 2, 3, 4, 5).forEach {
                if (it == 3) return@loop // non-local return from the lambda passed to run
                println(it)
            }
        }
        println("done with nested loop")
    }
}