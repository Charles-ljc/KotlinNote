package com.kotlin.note.`class`

/**
 * [Interface](https://kotlinlang.org/docs/reference/interfaces.html)
 */
class InterfaceLearn {

    interface MyInterface {
        val prop: Int // abstract

        val propertyWithImplementation: String
            get() = "foo"

        fun foo() {
            print(prop)
        }

        val name: String
    }

    class Child : MyInterface {
        override val prop: Int = 29

        override val name: String get() = "name"
    }
}