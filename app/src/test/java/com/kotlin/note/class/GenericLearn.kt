package com.kotlin.note.`class`

/**
 * [Generic](https://kotlinlang.org/docs/reference/generics.html)
 *
 * 重难点
 */
class GenericLearn {

    /**
     * T被声明为out，查看 [List]
     */
    interface Producer<out T> {

        // T作为只读属性的类型
        val value: T

        // T作为函数返回值的类型
        fun produce(): T

        // T作为只读属性的类型List泛型的类型实参
        val list: List<T>

        // T作为函数返回值的类型List泛型的类型实参
        fun produceList(): List<T>

        // fun consume(value: T) // error
    }

    /**
     * T被声明为in，查看 [Comparable]
     */
    interface Consumer<in T> {

        // T作为函数形参类型
        fun consume(value: T)

        // T作为函数形参的类型List泛型的类型实参
        fun consumeList(list: List<T>)

        // fun produce(): T // error
    }

    /**
     * 不型变，查看[MutableList] [Array]
     */
    interface SourceStandard<T> {
        fun nextT(t: T)

        fun nextT(): T
    }

    fun demo(strs: Producer<String>) {
        val objects: Producer<Any> = strs // This is OK, since T is an out-parameter
    }

    fun copy(from: Array<out Any>, to: Array<Any>) {}

    fun fill(dest: Array<in String>, value: String) {}

    fun testUseSiteVariance() {
        copy(arrayOf(123), arrayOf("1"))
        fill(arrayOf("11"), "11")
    }

    /**
     * Upper bounds
     */
    interface SourceExtend<T : CharSequence> {
        fun nextT(t: T)

        fun nextT(): T
    }

    fun <T> copyWhenGreater()
            where T : CharSequence,
                  T : Comparable<T> {
    }
}