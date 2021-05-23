package com.tedneward.minicalc

import com.tedneward.minicalc.MiniCalcLexer
import org.antlr.v4.runtime.CharStreams
import java.io.StringReader

fun lexerForCode(code: String) = MiniCalcLexer(CharStreams.fromReader(StringReader(code)))
