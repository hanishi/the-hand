package com.gilt.thehand.rules.typed

import com.gilt.thehand.{AbstractContext, Context, Rule, AbstractRuleSpec}

class StringEqSpec extends AbstractRuleSpec {
  val testCases: Map[Rule, (Set[AbstractContext], Set[AbstractContext])] = Map(
    StringEq("1") -> (
        Set(Context(1)),
        Set(Context(1.0), Context(BigDecimal("1.00")), Context(true))
      ),
    StringEq("a") -> (
        Set(Context('a')),
        Set(Context(97), Context("aa"), Context("b"), Context(true))
      ),
    StringEq("ab") -> (
        Set(Context("ab")),
        Set(Context(97), Context("aab"), Context("abb"), Context(true))
      )
  )

  runTests(testCases)
}
