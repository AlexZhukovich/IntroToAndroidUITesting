package com.alexzh.testapp.ui.settings

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.fail
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Test suite for checking the SettingsActivity class from a UI perspective.
 *
 * In Android project often used preferences from "Support Libraries" or "AndroidX".
 * This is very important to know which Preferences used in tested project because under the hood
 * they used different technologies.
 *
 * The "Support Libraries" implementation use ListView for rendering Preferences. As a result we
 * should test them with the onData method.
 *
 * The "AndroidX" implementation uses RecyclerView for displaying Preferences. As a result, we can
 * use the onView method for the testing screen with Preferences. Espresso framework has many build-in
 * tools for work with RecyclerView, like RecyclerViewActions from "espresso-contrib" library.
 *
 * Note: This class can be run without any pre-requirements.
 * The SettingsActivity class doesn't verify if User logged in because the main idea of the project
 * is learning basics of Espresso framework. You can check I'mBarista project for more complex
 * practices and test cases.
 */
@RunWith(AndroidJUnit4::class)
class SettingsActivityTest {

    @Rule
    @JvmField
    val activity = ActivityTestRule(SettingsActivity::class.java)

    /**
     * Test case:
     *  - the "Messages" category should be displayed
     *  - the "Sync" category should be displayed
     *
     * Notes:
     *  - the "Messages" string can be found in strings.xml file as messages_header const
     *  (R.string.messages_header)
     *  - the "Sync" string can be found in strings.xml file as sync_header const
     *  (R.string.sync_header)
     *
     * Hint(s):
     *  - check which preferences are used "Support Libraries" vs "AndroidX" (read more about
     *  difference in comment for the class). You can check the /res/xml/root_preferences.xml
     *  for understanding which preferences are used in the project.
     *  - check ID of Preferences container (ListView or RecyclerView). The "UiAutomatorViewer"
     *  and "Layout Inspector" can help with it.
     *  - the checking descendant property can done with RecyclerViewMatchers#atPosition ViewMatcher
     *  (can be not implemented yet).
     *  - the preference item often has 2 descends: title and value.
     */
    @Test
    fun shouldMessagesAndSyncCategoriesDisplayed() {
        fail()
    }

    /**
     * Test case:
     *  -
     *
     * Notes:
     *  -
     *
     * Hint(s):
     *  -
     */
    @Test
    fun shouldMessagesPropertiesHaveDefaultValues() {
        fail()
    }

    /**
     * Test case:
     *  -
     *
     * Notes:
     *  -
     *
     * Hint(s):
     *  -
     */
    @Test
    fun shouldSyncPropertiesHaveDefaultValues() {
        fail()
    }

    /**
     * Test case:
     *  -
     *
     * Notes:
     *  -
     *
     * Hint(s):
     *  -
     */
    @Test
    fun shouldChangeDefaultValueOfYourSignature() {
        fail()
    }

    /**
     * Test case:
     *  -
     *
     * Notes:
     *  -
     *
     * Hint(s):
     *  -
     */
    @Test
    fun shouldChangeDefaultValueOfDefaultReplyAction() {
        fail()
    }

    /**
     * Test case:
     *  -
     *
     * Notes:
     *  -
     *
     * Hint(s):
     *  -
     */
    @Test
    fun shouldChangeDefaultValueOfSyncEmailPeriodically() {
        fail()
    }

    /**
     * Test case:
     *  -
     *
     * Notes:
     *  -
     *
     * Hint(s):
     *  -
     */
    @Test
    fun shouldChangeDefaultValueOfDownloadIncomingAttachments() {
        fail()
    }
}
