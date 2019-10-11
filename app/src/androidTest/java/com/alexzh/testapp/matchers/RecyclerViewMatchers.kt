package com.alexzh.testapp.matchers

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher

/**
 * Custom matchers for [RecyclerView] class.
 */
object RecyclerViewMatchers {

    /**
     * Returns a matcher that matches [View] that contains number of items in RecyclerView
     * associated with the given id.
     *
     * @param count the number of items in [RecyclerView].
     */
    fun withItemCount(count: Int): Matcher<View> {

        /**
         * BoundedMatcher has a matcher sugar that lets you create a matcher for a given type
         * but only process items of a specific subtype of that matcher.
         */
        return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {

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
             * Evaluates the matcher for [RecyclerView].
             *
             * @param recyclerView the [RecyclerView] view to check the title.
             *
             * Hint:
             *  - the recyclerView object has access to Adapter use `recyclerView?.adapter` property.
             *  Under the hood the [RecyclerView.getAdapter] method will be called.
             *  - the adapter object has access to number of items in Adapter use `adapter?.itemCount`
             *  property. Under the hood the [RecyclerView.Adapter.getItemCount] method will be called.
             *  - the count object can be compared with number of items in adapter.
             */
            override fun matchesSafely(recyclerView: RecyclerView?): Boolean {
                // should be implemented
                return false
            }
        }
    }

    /**
     * Returns a matcher that matches [View] that contains number of items in RecyclerView
     * associated with the given id.
     *
     * @param count the number of items in [RecyclerView].
     */

    /**
     * Returns a matcher that matches [View] that contains view at specified position
     * in RecyclerView associated with the given id.
     */
    fun atPosition(position: Int, itemMatcher: Matcher<View>): Matcher<View> {

        /**
         * BoundedMatcher has a matcher sugar that lets you create a matcher for a given type
         * but only process items of a specific subtype of that matcher.
         */
        return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {

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
             * Evaluates the matcher for [RecyclerView].
             *
             * @param recyclerView the [RecyclerView] view to check the title.
             *
             * Hint:
             *  - the recyclerView item has a [RecyclerView.ViewHolder] object which allows to work with View
             *  inside each ViewHolder. We can get access to ViewHolder use
             *  `recyclerView?.findViewHolderForAdapterPosition(POSITION)` method.
             *  - the ViewHolder object has access to the view inside ViewHolder use `viewHolder?.itemView`
             *  property.
             *  - the itemMatcher can be evaluated with an argument using the [Matcher.matches] method
             *  `itemMatcher.matches(VIEW)`.
             */
            override fun matchesSafely(recyclerView: RecyclerView?): Boolean {
                // should be implemented
                return false
            }
        }
    }
}
