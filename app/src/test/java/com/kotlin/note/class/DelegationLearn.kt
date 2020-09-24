package com.kotlin.note.`class`

import org.junit.Test

/**
 * [Delegation](https://kotlinlang.org/docs/reference/delegation.html)
 */
class DelegationLearn {

    interface Base {
        val message: String
        fun printX()
        fun printMessage()
    }

    class BaseImpl(val x: Int) : Base {
        override val message = "BaseImpl: x = $x"
        override fun printX() {
            println(x)
        }

        override fun printMessage() {
            println(message)
        }
    }

    class Derived(b: Base) : Base by b {
        // b 的 printMessage 无法访问该 message
        override val message = "Message of Derived"

        // 该方法会覆盖委托的实现
        override fun printX() {
            println("abc")
        }
    }

    @Test
    fun testDelegation() {
        val b = BaseImpl(10)
        val derived = Derived(b)
        derived.printX() // abc
        derived.printMessage() // BaseImpl: x = 10
        println(derived.message) // Message of Derived
    }

}