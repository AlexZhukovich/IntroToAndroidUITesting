package com.alexzh.testapp.matchers

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

object RecyclerViewMatchers {

    fun withItemCount(count: Int): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            override fun matchesSafely(view: View): Boolean {
                return false
            }

            override fun describeTo(description: Description) {

            }
        }
    }

    fun atPosition(position: Int, itemMatcher: Matcher<View>): Matcher<View> {
        return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
            override fun describeTo(description: Description) {

            }

            override fun matchesSafely(view: RecyclerView): Boolean {
                return false
            }
        }
    }
}
