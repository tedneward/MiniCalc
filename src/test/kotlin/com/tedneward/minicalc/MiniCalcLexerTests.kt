/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.tedneward.minicalc

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertEquals
import org.antlr.v4.runtime.Token
import java.io.FileInputStream
import java.io.StringReader

fun tokensMap(lexer: MiniCalcLexer, transform: (Token) -> String): List<String> {
    val tokens : MutableList<String> = mutableListOf()
    do {
        val t = lexer.nextToken()
        when (t.type) {
            -1 -> tokens.add("EOF")
            else -> if (t.type != MiniCalcLexer.WS) tokens.add(transform(t))
        }
    } while (t.type != -1)
    return tokens
}

fun tokensMapContent(lexer: MiniCalcLexer) = tokensMap(lexer, { _ -> lexer.text })
fun tokensMapNames(lexer: MiniCalcLexer) = tokensMap(lexer, { t -> lexer.vocabulary.getSymbolicName(t.type) })

class MiniCalcLexerTests {
    val tests = mapOf(
        "var a = 1" to listOf("VAR", "ID", "ASSIGN", "INTLIT", "EOF"),
        "var a = 1.23" to listOf("VAR", "ID", "ASSIGN", "DECLIT", "EOF"),
        "var a = 1 + 2" to listOf("VAR", "ID", "ASSIGN", "INTLIT", "PLUS", "INTLIT", "EOF"),
        "1 + a * 3 / 4 - 5" to listOf("INTLIT", "PLUS", "ID", "ASTERISK", "INTLIT", "DIVISION", "INTLIT", "MINUS", "INTLIT", "EOF")
    )

    @Test fun parseTests() {
        for ((k,v) in tests) {
            assertEquals(v, tokensMapNames(lexerForCode(k)))
        }
    }

    /*
input Int width
input Int height
var area = width * height
print("A rectangle #{width}x#{height} has an area #{area}")
     */
    val rectangleTests = mapOf(
        "input Int width" to listOf("INPUT", "INT", "ID"),
        "input Int height" to listOf("INPUT", "INT", "ID"),
        "var area = width * height" 
            to listOf("VAR", "ID", "ASSIGN", "ID", "ASTERISK", "ID"),
        "print (\"A rectangle #{width}x#{height} has an area #{area}\")"
            to listOf("PRINT", "LPAREN", "STRING_OPEN", 
                "STRING_CONTENT", "INTERPOLATION_OPEN", "ID", "INTERPOLATION_CLOSE",
                "STRING_CONTENT", "INTERPOLATION_OPEN", "ID", "INTERPOLATION_CLOSE",
                "STRING_CONTENT", "INTERPOLATION_OPEN", "ID", "INTERPOLATION_CLOSE",
                "STRING_CLOSE", "RPAREN")
    )
    @Test fun rectangleExampleLineTest() {
        for ((k,v) in tests) {
            assertEquals(v, tokensMapNames(lexerForCode(k)))
        }
    }
}
