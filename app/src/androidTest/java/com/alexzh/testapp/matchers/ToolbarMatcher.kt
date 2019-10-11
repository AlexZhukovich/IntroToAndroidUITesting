package com.alexzh.testapp.matchers

import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher

/**
 * Custom matchers for [Toolbar] class.
 */
object ToolbarMatcher {

    /**
     * Returns a matcher that matches [View] that  is displaying the string in Toolbar
     * associated with the given id.
     *
     * @param textMatcher the string matcher the toolbar title is expected to hold.
     */
    fun withToolbarTitle(textMatcher: Matcher<String>): Matcher<View> {

        /**
         * BoundedMatcher has a matcher sugar that lets you create a matcher for a given type
         * but only process items of a specific subtype of that matcher.
         */
        return object : BoundedMatcher<View, Toolbar>(Toolbar::class.java) {

            /**
             * Generate a description of why the matcher has not accepted the item.
             *
             * @param description the description for the matcher which allows to report evaluation
             * matcher issue.
             *
             * Hint:
             *  - the description parameter should be used in a proper way to reporting issues
             *  correctly. It's partially filled by matcher.
             *  ```
             *  override fun describeTo(description: Description?) {
             *      description.appendText(EXPECTED-VALUE)
             *  }
             *  ```
             *  Output:
             *  > java.lang.AssertionError:
             *  > Expected: EXPECTED-VALUE
             *  >      got: ACTUAL-VALUE
             */
            override fun describeTo(description: Description?) {
                // should be implemented
            }

            /**
             * Evaluates the matcher for toolbar.
             *
             * @param toolbar the [Toolbar] view to check the title.
             *
             * Hint:
             *  - the title of toolbar can be get from the title property: `toolbar?.title`.
             *  Under the hood the [Toolbar.getTitle] method will be called.
             *  - the textMatcher can be evaluated with an argument using the [Matcher.matches] method
             *  `textMatcher.matches(TOOLBAR TITLE)`
             */
            override fun matchesSafely(toolbar: Toolbar?): Boolean {
                // should be implemented
                return false
            }
        }
    }
}
