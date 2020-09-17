package com.kotlin.note.`class`

import org.junit.Test

/**
 * [Class](https://kotlinlang.org/docs/reference/classes.html)
 */
class ClassLearn {

    @Test
    fun testConstructor() {
        PrimaryConstructor()
    }

    @Test
    fun testInitOrder() {
        InitOrder()
    }

    @Test
    fun testSecondaryConstructor() {
        SecondaryConstructor()
    }

    @Test
    fun testDerivedInitOrder() {
        DerivedInitOrder("hello", "world")
    }

    ///
    // 主构造函数如果没有任何注解或可见性修饰符，constructor 关键字可以省略。
    // 主构造函数不能包含任何代码。初始化代码放在 init 块内。
    private class PrimaryConstructor private constructor() {

        constructor(string: String = "") : this() {
            println("constructor string=$string")
        }
    }

    ///
    // 初始化顺序为代码的顺序
    private class InitOrder {
        val firstProperty = "First property".also(::println)

        init {
            println("First initializer block")
        }

        val secondProperty = "Second property".also(::println)

        init {
            println("Second initializer block")
        }
    }

    ///
    // 次构造
    private class SecondaryConstructor {

        constructor() {
            println("Constructor")
        }

        constructor(i: Int) {
            println("Constructor")
        }

        init {
            // 在次构造之前执行，与代码位置无关
            println("Init block")
        }
    }

    ///
    // final 类中的 open 修饰符无效，因为类无法被继承
    private class OpenFunctionInFinalClass {

        open val i: Int = 1

        open fun test() {

        }
    }

    ///
    // 覆盖属性
    // 子类中属性类型必须是父类属性类型的子类，反之无效
    // 父类用 val 修饰，子类可以改为 var，反之无效
    private open class OverrideProperty {

        open val number: Number = 0F
    }

    private class DeclaredOverrideProperty : OverrideProperty() {

        override var number: Int = 0
    }

    ///
    // 派生类执行顺序
    private open class Base(name: String) {

        init {
            println("Initializing Base")
        }

        open val size: Int =
            name.length.also { println("Initializing size in Base: $it") }
    }

    private class DerivedInitOrder(
        name: String,
        lastName: String,
    ) : Base(name.capitalize().also { println("Argument for Base: $it") }) {

        init {
            println("Initializing Derived")
        }

        override val size: Int =
            (super.size + lastName.length).also { println("Initializing size in Derived: $it") }
    }

    ///
    // 重写规则
    private open class Rectangle {
        open fun draw() { /* ... */
        }
    }

    private interface Polygon {
        fun draw() { /* ... */
        } // interface members are 'open' by default
    }

    private class Square() : Rectangle(), Polygon {
        // The compiler requires draw() to be overridden:
        override fun draw() {
            super<Rectangle>.draw() // call to Rectangle.draw()
            super<Polygon>.draw() // call to Polygon.draw()
        }
    }
}

