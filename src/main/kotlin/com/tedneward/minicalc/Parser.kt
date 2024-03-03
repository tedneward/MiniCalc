package com.tedneward.minicalc

import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.Vocabulary
import org.antlr.v4.runtime.tree.TerminalNode

fun parseCode(code: String) : MiniCalcParser.MiniCalcFileContext = 
    MiniCalcParser(CommonTokenStream(lexerForCode(code))).miniCalcFile()

fun toParseTree(node: ParserRuleContext, vocabulary : Vocabulary) : ParseTreeNode {
    val res = ParseTreeNode(node.javaClass.simpleName.removeSuffix("Context"))
    node.children.forEach { c ->
        when (c) {
            is ParserRuleContext -> res.child(toParseTree(c, vocabulary))
            is TerminalNode -> res.child(ParseTreeLeaf(vocabulary.getSymbolicName(c.symbol.type), c.text))
        }
    }
    return res
}

abstract class ParseTreeElement {
    abstract fun multiLineString(indentation : String = "") : String
}

class ParseTreeLeaf(val type: String, val text: String) : ParseTreeElement() {
    override fun toString(): String = "T: $type[$text]"
    override fun multiLineString(indentation: String) : String = "${indentation}${toString()}\n"
}

class ParseTreeNode(val name: String) : ParseTreeElement() {
    val children : MutableList<ParseTreeElement> = mutableListOf()
    fun child(c : ParseTreeElement) : ParseTreeNode {
        children.add(c)
        return this
    }
    override fun toString(): String {
        return "Node($name)"
    }
    override fun multiLineString(indentation: String) : String {
        val sb = StringBuilder()
        sb.append("${indentation}$name\n")
        children.forEach { c -> sb.append(c.multiLineString(indentation + " ")) }
        return sb.toString()
    }
}

fun MiniCalcParser.MiniCalcFileContext.toAst() : MiniCalcFileAST {
    return MiniCalcFileAST()
}

/*
fun MiniCalcParser.MiniCalcFileContext.toAst(considerPosition: Boolean = false) : MiniCalcFile = 
    MiniCalcFile(this.line().map { it.statement().toAst(considerPosition) }, toPosition(considerPosition))

fun MiniCalcParser.StatementContext.toAst(considerPosition: Boolean = false) : Statement = when (this) { 
    is MiniCalcParser.VarDeclarationStatementContext -> VarDeclaration(varDecl().assignment().ID().text,
            varDecl().assignment().expr().toAst(considerPosition),
            toPosition(considerPosition))
    is MiniCalcParser.AssignmentStatementContext -> Assignment(ReferenceByName(assignment().ID().text), 
            assignment().expr().toAst(considerPosition), toPosition(considerPosition))
    is MiniCalcParser.PrintStatementContext -> Print(print().expr().toAst(considerPosition), toPosition(considerPosition))
    is MiniCalcParser.InputDeclarationStatementContext -> InputDeclaration(this.inputDeclaration().ID().text, this.inputDeclaration().type().toAst(considerPosition), toPosition(considerPosition))
    else -> throw UnsupportedOperationException(this.javaClass.canonicalName) 
}

fun MiniCalcParser.ExpressionContext.toAst(considerPosition: Boolean = false) : Expression = when (this) {
    is MiniCalcParser.BinaryOperationContext -> toAst(considerPosition)
    is MiniCalcParser.IntLiteralContext -> IntLiteral(text, toPosition(considerPosition))
    is MiniCalcParser.DecimalLiteralContext -> DecimalLiteral(text, toPosition(considerPosition))
    is MiniCalcParser.StringLiteralContext -> StringLiteral(this.parts.map { it.toAst(considerPosition) }, toPosition(considerPosition))
    is MiniCalcParser.ParenExpressionContext -> expression().toAst(considerPosition)
    is MiniCalcParser.ValueReferenceContext -> ValueReference(ReferenceByName(text), toPosition(considerPosition))
    is MiniCalcParser.TypeConversionContext -> TypeConversion(expression().toAst(considerPosition), targetType.toAst(considerPosition), toPosition(considerPosition))
    else -> throw UnsupportedOperationException(this.javaClass.canonicalName)
}

fun MiniCalcParser.StringLiteralContentContext.toAst(considerPosition: Boolean = false) : StringLiteralPart = when (this) {
    is MiniCalcParser.ConstantStringContext -> ConstantStringLiteralPart(this.STRING_CONTENT().text, toPosition(considerPosition))
    is MiniCalcParser.InterpolatedValueContext -> ExpressionStringLiteralPart(this.expression().toAst(considerPosition), toPosition(considerPosition))
    else -> throw UnsupportedOperationException(this.javaClass.canonicalName)
}

fun MiniCalcParser.TypeContext.toAst(considerPosition: Boolean = false) : Type = when (this) { is IntegerContext -> IntType(toPosition(considerPosition))
    is MiniCalcParser.DecimalContext -> DecimalType(toPosition(considerPosition))
    else -> throw UnsupportedOperationException(this.javaClass.canonicalName)
}

fun MiniCalcParser.BinaryOperationContext.toAst(considerPosition: Boolean = false) : Expression = when (operator.text) {
    "+" -> AdditionExpression(left.toAst(considerPosition), right.toAst(considerPosition), toPosition(considerPosition))
    "-" -> SubtractionExpression(left.toAst(considerPosition), right.toAst(considerPosition), toPosition(considerPosition))
    "*" -> MultiplicationExpression(left.toAst(considerPosition), right.toAst(considerPosition), toPosition(considerPosition))
    "/" -> DivisionExpression(left.toAst(considerPosition), right.toAst(considerPosition), toPosition(considerPosition))
    else -> throw UnsupportedOperationException(this.javaClass.canonicalName) 
}
*/