package com.kotlin.note.`class`

import org.junit.Test

/**
 * [Extension](https://kotlinlang.org/docs/reference/extensions.html)
 */
class ExtensionLearn {

    @Test
    fun testRuntime() {
        open class Shape

        class Rectangle : Shape()

        fun Shape.getName() = "Shape"

        fun Rectangle.getName() = "Rectangle"

        fun printClassName(s: Shape) {
            println(s.getName())
        }

        printClassName(Rectangle())
    }

    /**
     * 类的成员方法比同签名的扩展方法优先级高
     */
    @Test
    fun testSameSignatureFunc() {
        class Example {
            fun printFunctionType() {
                println("Class method")
            }
        }

        fun Example.printFunctionType() {
            println("Extension function")
        }

        Example().printFunctionType() // 输出 Class method
    }

    /**
     * 可以重写同名不同参的方法
     */
    @Test
    fun testSameNameFunc() {
        class Example {
            fun printFunctionType() {
                println("Class method")
            }
        }

        fun Example.printFunctionType(i: Int) {
            println("Extension function")
        }

        Example().printFunctionType(1)
    }

    /**
     * 伴生对象扩展方法，仍通过类名访问
     */
    class MyClass {
        companion object {}  // will be called "Companion"
    }

    @Test
    fun testCompanionObject() {
        fun MyClass.Companion.printCompanion() {
            println("companion")
        }

        MyClass.printCompanion()
    }

    @Test
    fun testDispatchReceiver() {
        class Host(val hostname: String) {
            fun printHostname() {
                print(hostname)
            }
        }

        class Connection(val host: Host, val port: Int) {
            fun printPort() {
                print(port)
            }

            fun Host.printConnectionString() {
                printHostname()   // calls Host.printHostname()
                print(":")
                printPort()   // calls Connection.printPort()
            }

            fun connect() {
                /*...*/
                host.printConnectionString()   // calls the extension function
            }
        }

        Connection(Host("kotl.in"), 443).connect() // 输出 kotl.in:443
        //Host("kotl.in").printConnectionString(443)  // error, the extension function is unavailable outside Connection
    }
}