package com.tedneward.minicalc

import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Vocabulary
import org.antlr.v4.runtime.tree.TerminalNode

fun parseCode(code: String) : MiniCalcParser.MiniCalcFileContext = MiniCalcParser(CommonTokenStream(lexerForCode(code))).miniCalcFile()

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

