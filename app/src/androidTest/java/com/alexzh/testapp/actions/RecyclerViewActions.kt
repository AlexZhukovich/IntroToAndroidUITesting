package com.alexzh.testapp.actions

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import org.hamcrest.Matcher

/**
 * Custom actions for [androidx.recyclerview.widget.RecyclerView] class.
 */
object RecyclerViewActions {

    /**
     * Returns an action that clicks the child view for a specific id.
     *
     * @param id the child view id, which should be clicked.
     */
    fun clickByChildViewWithId(id: Int): ViewAction {

        /**
         * The ViewAction is responsible for performing an interaction on the given View element.
         */
        return object : ViewAction {

            /**
             * A mechanism for ViewActions to specify what type of views they can operate on.
             * ```
             * override fun getConstraints(): Matcher<View>? {
             *     return allOf(
             *         withEffectiveVisibility(Visibility.VISIBLE),
             *         isAssignableFrom(Button.class)
             *     )
             * }
             * ```
             */
            override fun getConstraints(): Matcher<View>? {
                // should be implemented
                return null
            }

            /**
             * Returns a description of the view action. The description should not be overly long and should
             * fit nicely in a sentence like: "performing %description% action on view with id ..."
             */
            override fun getDescription(): String {
                // should be implemented
                return ""
            }

            /**
             * Performs the action on the given view.
             *
             * Hint:
             *  - the view can contains subviews which can be found using `view.findViewById<View>(ID)`
             *  method.
             *  - the view can be clicked use `view.performClick()` method.
             */
            override fun perform(uiController: UiController, view: View) {
                // should be implemented
            }
        }
    }
}
