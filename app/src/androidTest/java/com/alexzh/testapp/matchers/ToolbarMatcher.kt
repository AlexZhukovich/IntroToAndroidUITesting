package com.alexzh.testapp.matchers

import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher

object ToolbarMatcher {

    fun withToolbarTitle(textMatcher: Matcher<String>): Matcher<View> {
        return object : BoundedMatcher<View, Toolbar>(Toolbar::class.java) {
            override fun describeTo(description: Description?) {
                // should be implemented
            }

            override fun matchesSafely(toolbar: Toolbar?): Boolean {
                return false
            }
        }
    }
}
