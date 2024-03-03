package com.tedneward.minicalc

import java.lang.reflect.ParameterizedType
import kotlin.reflect.full.memberProperties

// My AST (as opposed to Tomassi's AST)

data class MiniCalcFileAST(val filename: String? = null): Node {
    override fun toString(): String {
        return "Source: ${filename}"
    }
}

















data class Point(val line: Int, val column: Int) {
    
    override fun toString() = "Line $line, Column $column"
    
    /**
     * Translate the Point to an offset in the original code stream.
     */
    fun offset(code: String) : Int {
        val lines = code.split("\n")
        val newLines = this.line - 1
        return lines.subList(0, this.line - 1).foldRight(0, { it, acc -> it.length + acc }) + newLines + column
    }

    fun isBefore(other: Point) : Boolean = 
        line < other.line || (line == other.line && column < other.column) 
}

data class Position(val start: Point, val end: Point) {
    init {
        if (end.isBefore(start)) {
            throw IllegalArgumentException("End should follows start") }
    }

    /**
     * Given the whole code extract the portion of text corresponding to this position
     */
    fun text(wholeText: String): String {
        return wholeText.substring(start.offset(wholeText), end.offset(wholeText))
    }
    fun length(code: String) = end.offset(code) - start.offset(code) 
}

/**
 * Utility function to create a Position
 */
fun pos(startLine:Int, startCol:Int, endLine:Int, endCol:Int) = Position(Point(startLine,startCol),Point(endLine,endCol))

/**
 * Node and utility methods
 */
interface Node {
//    val position: Position?
}

//fun Node.process(operation: (Node) -> Unit) {
//    operation(this)
//    this.javaClass.kotlin.memberProperties.forEach { p ->
//        val v = p.get(this)
//        when (v) {
//            is Node -> v.process(operation)
//            is Collection<*> -> v.forEach { if (it is Node) it.process(operation) }
//        }
//    }
//}

//fun <T: Node> Node.specificProcess(klass: Class<T>, operation: (T) -> Unit) {
//    process { if (klass.isInstance(it) { operation(it as T) } ) }
//}

//fun Node.isBefore(other: Node) : Boolean = position!!.start.isBefore(other.position!!.start)

/*
fun Node.multilineString(indent: String = "") : String {
    val indentBlock = "  "
    
    val sb = StringBuffer()
    sb.append("$indent${this.javaClass.simpleName} {\n")

    this.javaClass.kotlin.memberProperties.filter { it -> !it.name.startsWith("component") && !it.name.equals("position") }.forEach { 
        val mt = it.returnType.javaClass
        if (mt is ParameterizedType && mt.rawType.equals(List::class.java)) {
            val paramType = mt.actualTypeArguments[0]
            if (paramType is Class<*> && Node::class.java.isAssignableFrom(paramType)) {
                sb.append("$indent$indentBlock${it.name} = [\n")
                (it.get(this) as List<out Node>).forEach { sb.append(it.multilineString(indent + indentBlock + indentBlock)) }
                sb.append("$indent$indentBlock]\n")
            } 
        } else {
            val value = it.get(this) 
            if (value is Node) {
                sb.append("$indent$indentBlock${it.name} = [\n")
                sb.append(value.multilineString(indent + indentBlock + indentBlock))
                sb.append("$indent$indentBlock]\n")
            } else {
                sb.append("$indent$indentBlock${it.name} = ${it.get(this)}\n")
            }
        }
    }

    sb.append("$indent}\n")
    return sb.toString() 
}
*/

interface Named {
    val name: String
}

data class ReferenceByName<N>(val name: String, var referred: N? = null) where N : Named {
    override fun toString(): String {
        return if (referred == null) "Ref($name)[Unsolved]" else "Ref($name)[Solved]"
    }
}

fun <N> ReferenceByName<N>.tryToResolve(candidates: List<N>): Boolean where N : Named {
    val res = candidates.find { it.name == this.name }
    this.referred = res
    return res != null
}

////////////////////
// MiniCalc-specific
/*
data class MiniCalcFile(val statements: List<Statement>, override val position: Position? = null) : Node

interface Type : Node

data class IntType(override val position: Position? = null) : Type

data class DecimalType(override val position: Position? = null) : Type

data class StringType(override val position: Position? = null) : Type

interface Expression : Node

data class UnaryMinusExpression(val value : Expression, override val position: Position? = null) : Expression

data class TypeConversionExpression(val value : Expression, val targetType: Type, override val position: Position? = null) : Expression

data class ValueReference(val ref: ReferenceByName<ValueDeclaration>, override val position: Position? = null) : Expression

data class IntLiteral(val value: String, override val position: Position? = null) : Expression

data class DecimalLiteral(val value: String, override val position: Position? = null) : Expression

data class StringLiteral(val parts: List<StringLiteralPart>, override val position: Position? = null) : Expression

interface StringLiteralPart : Node

data class ConstantStringLiteralPart(val content: String, override val position: Position? = null) : StringLiteralPart

data class ExpressionStringLiteralPart(val expression: Expression, override val position: Position? = null) : StringLiteralPart

interface BinaryExpression : Expression {
    val left: Expression
    val right: Expression
}

data class AdditionExpression(override val left: Expression, override val right: Expression, override val position: Position? = null) : BinaryExpression
data class SubtractionExpression(override val left: Expression, override val right: Expression, override val position: Position? = null) : BinaryExpression
data class MultiplicationExpression(override val left: Expression, override val right: Expression, override val position: Position? = null) : BinaryExpression
data class DivisionExpression(override val left: Expression, override val right: Expression, override val position: Position? = null) : BinaryExpression

interface Statement : Node

interface ValueDeclaration : Statement, Named

data class VarDeclaration(override val name: String, val value: Expression, override val position: Position? = null) : ValueDeclaration

data class InputDeclaration(override val name: String, val type: Type, override val position: Position? = null) : ValueDeclaration

data class Assignment(val varDecl: ReferenceByName<VarDeclaration>, val value: Expression, override val position: Position? = null) : Statement

data class Print(val value: Expression, override val position: Position? = null) : Statement

*/
