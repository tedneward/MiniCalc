/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.tedneward.minicalc

import com.tedneward.minicalc.MiniCalcLexer
import java.io.FileInputStream

fun main(args: Array<String>) {
    println(
        toParseTree(
            parseCode(FileInputStream("examples/rectangle.mc").bufferedReader().use { it.readText() }), 
            MiniCalcParser.VOCABULARY
        ).multiLineString()
    )
}
