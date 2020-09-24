package com.kotlin.note.`class`

import org.junit.Test
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * [DelegatedProperty](https://kotlinlang.org/docs/reference/delegated-properties.html)
 */
class DelegatedPropertyLearn {

    class Example {
        var p: String by Delegate()
    }

    class Delegate {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return "$thisRef, thank you for delegating '${property.name}' to me!"
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            println("$value has been assigned to '${property.name}' in $thisRef.")
        }
    }

    @Test
    fun testDelegatedProperty() {
        val e = Example()
        println(e.p)
        e.p = "NEW"
    }

    /**
     * 第一次会执行 lambda，以后直接返回值。
     *
     * 默认是同步的，可以改为异步。
     */
    @Test
    fun testLazy() {
        val lazyValue: String by lazy {
            println("computed!")
            "Hello"
        }

        println("First")
        println(lazyValue)
        println("Second")
        println(lazyValue)
    }

    /**
     * Observable
     *
     * 在赋值之后执行
     */
    @Test
    fun testObservable() {
        class User {
            var name: String by Delegates.observable("<no name>") { prop, old, new ->
                // 在赋值之后执行
                println("$old -> $new")
            }
        }

        val user = User()
        user.name = "first"
        user.name = "second"
    }

    /**
     * Vetoable
     *
     * 在赋值之前执行，可以否决赋值操作
     */
    @Test
    fun testVetoable() {
        class User {
            var name: String by Delegates.vetoable("<no name>") { prop, old, new ->
                // 在赋值之前执行
                println("$old -> $new")
                // 返回 true 表示允许执行，false 表示不执行
                new != "null"
            }
        }

        val user = User()
        user.name = "first"
        user.name = "null"
        println(user.name)
    }

    /**
     * JSON
     */
    @Test
    fun testMap() {
        class User(val map: Map<String, Any?>) {
            val name: String by map
            val age: Int by map
        }

        val user = User(
            mapOf(
                "name" to "John Doe",
                "age" to 25
            )
        )

        println(user.name) // Prints "John Doe"
        println(user.age)  // Prints 25
    }

}