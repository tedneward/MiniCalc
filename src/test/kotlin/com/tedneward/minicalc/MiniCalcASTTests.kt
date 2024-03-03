package com.tedneward.minicalc

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertEquals
import org.antlr.v4.runtime.CommonTokenStream

class MiniCalcASTTests {
    @Test fun firstTest() {
        val resourceName = "vardecl"
        val ast = MiniCalcParser(CommonTokenStream(lexerForResource(resourceName, this.javaClass))).miniCalcFile().toAst()
    }
}
