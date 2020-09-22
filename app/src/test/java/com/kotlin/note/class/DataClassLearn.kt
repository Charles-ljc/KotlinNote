package com.kotlin.note.`class`

import org.junit.Test

/**
 * [DataClass](https://kotlinlang.org/docs/reference/data-classes.html)
 */
class DataClassLearn {

    /**
     * 只有主构造函数中的参数才会用在 toString(), equals(), hashCode(), copy() 方法中
     */
    @Test
    fun testProperty() {
        data class Person(val name: String) {
            var age: Int = 0
        }

        val person1 = Person("John")
        val person2 = Person("John")
        person1.age = 10
        person2.age = 20

        println(person1 == person2) // true
    }

    /**
     * 解构
     */
    @Test
    fun testDeconstruction() {
        data class User(val name: String = "", val age: Int = 0)

        val jane = User("Jane", 35)
        val (name, age) = jane
        println("$name, $age years of age") // prints "Jane, 35 years of age"
    }

    /**
     * 标准库
     */
    @Test
    fun testStandard() {
        val user1: Pair<String, Int> = Pair("full name", 10)

        val user2: Triple<String, String, Int> = Triple("first name", "last name", 10)

        println("user1: $user1")
        println("user2: $user2")
    }
}