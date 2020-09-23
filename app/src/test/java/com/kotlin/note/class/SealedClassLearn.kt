package com.kotlin.note.`class`

/**
 * [SealedClass](https://kotlinlang.org/docs/reference/sealed-classes.html)
 */
class SealedClassLearn {

    /**
     * 密封子类的子类，不需要和密封类定义在一起
     */
    class ExtendSealedSubClass(e1: Expr, e2: Expr, override val count: Int) : Sum(e1, e2)
}

/**
 * 必须在外部声明，类是抽象的，不能直接实例化
 */
sealed class Expr {
    // 可以有抽象成员
    abstract val count: Int
}

// 抽象成员放在构造参数
data class Const(val number: Double, override val count: Int) : Expr()

// 类改为抽象
abstract class Sum(val e1: Expr, val e2: Expr) : Expr()

// 实现成员
object NotANumber : Expr() {
    override val count: Int
        get() = 5
}