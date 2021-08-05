package com.ford.viewMatchers

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.ViewAssertion

fun recyclerHasItemCount(expectedCount: Int): ViewAssertion = ViewAssertion { view, noViewFoundException ->
    if (noViewFoundException != null) {
        throw noViewFoundException
    }

    val itemCount = (view as RecyclerView).adapter?.itemCount
    assert(itemCount == expectedCount) { "Expected $expectedCount items, actual count $itemCount" }
}