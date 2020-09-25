package com.kotlin.note.function

import org.junit.Test

/**
 * [Function](https://kotlinlang.org/docs/reference/functions.html)
 */
class FunctionLearn {

    fun testOverriding() {
        open class A {
            open fun foo(i: Int = 10) { /*...*/
            }
        }

        class B : A() {
            // 此处不允许写默认值
            override fun foo(i: Int) { /*...*/
            }
        }
    }

    fun testDefault() {
        fun foo(
            bar: Int = 0,
            baz: Int,
        ) { /*...*/
        }

        foo(baz = 1) // The default value bar = 0 is used
    }

    fun testLambda() {
        fun foo(
            bar: Int = 0,
            baz: Int = 1,
            qux: () -> Unit,
        ) { /*...*/
        }

        foo(1) { println("hello") }     // Uses the default value baz = 1
        foo(qux = { println("hello") }) // Uses both default values bar = 0 and baz = 1
        foo { println("hello") }        // Uses both default values bar = 0 and baz = 1
    }

    @Test
    fun testVararg() {
        // 只有一个参数可以标记为 vararg，不需要放在最后
        fun <T> asList(vararg ts: T, a: Int = 1): List<T> {
            val result = ArrayList<T>()
            for (t in ts) // ts is an Array，类型 Array<out T>
                result.add(t)
            return result
        }

        // 使用 * 将 a 的子项传入
        val a = arrayOf(1, 2, 3)
        val list = asList(-1, 0, *a, 4)
        println(list)
    }

    fun testInfix() {
        class MyStringCollection {
            infix fun add(s: String) { /*...*/
            }

            fun build() {
                this add "abc"   // Correct 使用this
                add("abc")       // Correct
                //add "abc"        // Incorrect: the receiver must be specified
            }
        }
    }

    private val memberVariable = "member"

    fun testLocalFunction() {
        val visited = HashSet<String>()
        fun dfs(current: String) {
            // 可以访问外部的局部变量
            if (!visited.add(current)) return
            if (current == memberVariable) {
                println()
            }
        }
        dfs("test")
    }

    @Test
    fun testTailRecursive() {
        val eps = 1E-10 // "good enough", could be 10^-15

        tailrec fun findFixPoint(x: Double = 1.0): Double =
            if (Math.abs(x - Math.cos(x)) < eps) x else findFixPoint(Math.cos(x))

        val result = findFixPoint()
        println(result)
    }
}