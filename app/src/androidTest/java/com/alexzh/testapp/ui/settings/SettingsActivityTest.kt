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
 * Android projects often use preferences from "Support Libraries". Now with the advent of the
 * "AndroidX" libraries it is very important to know which ones are used in the tested project.
 * Although similar on the first glance they use different technologies under the hood.
 *
 * The "Support Libraries" implementation use ListView for rendering Preferences. As a result we
 * should test them with the onData method.
 *
 * The "AndroidX" implementation uses RecyclerView for displaying Preferences. As a result, we can
 * use the onView method for testing screen with Preferences. Espresso framework has many built-in
 * tools that allow one to work with a RecyclerView, like RecyclerViewActions from "espresso-contrib"
 * library.
 *
 * Note:
 * This class can be run without any pre-requirements.
 * The SettingsActivity class doesn't verify if the User is logged in because the main idea of the
 * project is to learn the basics of Espresso framework. You can check I'mBarista project for more
 * complex practices and test cases.
 */
@RunWith(AndroidJUnit4::class)
class SettingsActivityTest {

    /**
     * The {@link ActivityTestRule} provides functional testing of a single {@link Activity}.
     * The Espresso framework requires it for launching Activity for testings.
     *
     * We can configure activity before running in the following ways:
     *  - Using the {@link #ActivityTestRule(Class, boolean, boolean)} where the second parameter
     *  is initialTouchMode and the third one is launchActivity. If launch activity is true the
     *  Activity will be launched before the test case. It means we cannot configure it before
     *  executing the test case. If we want to configure which intent launch activity and pass
     *  additional parameters we can execute {@see activity#launchActivity(Intent)} method with
     *  required intent.
     *  ```
     *  @Rule @JvmField
     *  val activity = ActivityTestRule(HomeActivity::class.java, true, false)
     *
     *  @Before
     *  fun setUp() {
     *      val intent = ...
     *      activity.launchActivity(intent)
     *  }
     *  ```
     *  - Using the {@link ActivityTestRule#beforeActivityLaunched) method we can do additional
     *  action before executing test case, like configure Mock objects, clean database, etc.)
     *  ```
     *  @get: Rule
     *  val activity = object: ActivityTestRule<LoginActivity(LoginActivity::class.java>) {
     *      override fun beforeActivityLaunched() {
     *          super.beforeActivityLaunched()
     *          ...
     *      }
     *  }
     *  ```
     *
     * Note:
     *  - a field created for JUnit Rule should be public, not static, and a subtype of TestRule
     *  or MethodRule (https://junit.org/junit4/javadoc/4.12/org/junit/Rule.html)
     *  - In Kotlin we can use @get: Rule or @Rule @JvmField annotations for JUnit Rule fields
     */
    @get: Rule
    val activity = ActivityTestRule(SettingsActivity::class.java)

    /**
     * Test case:
     *  - Toolbar should have a text "Settings"
     *
     * Notes:
     *  - the "Toolbar" view has ID: settingsToolbar (R.id.settingsToolbar)
     *  - the "Settings" string can be found in strings.xml file as app_name const
     *  (R.string.screen_settings)
     *
     * Hint(s):
     *  - the toolbar title can be checked with ToolbarMatcher#withToolbarTitle ViewMatcher
     *  (can be not implemented yet).
     */
    @Test
    fun shouldToolbarContainsSettingsTitle() {
        fail()
    }

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
     *  difference in comment for the [SettingsActivityTest] class). You can check the
     *  /res/xml/root_preferences.xml for understanding which preferences are used in the project.
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
     *  - the "You signature" property has "Not set" default value
     *  - the "Default reply action" has "Reply" default value
     *
     * Notes:
     *  - the "Your signature" string can be found in stings.xml file as signature_title const
     *  (R.string.signature_title)
     *  - the "Default reply action" string can be found in stings.xml file as reply_title const
     *  (R.string.reply_title)
     *  - the "Reply" action" string can be found in stings.xml file as reply_entity const
     *  (R.string.reply_entity)
     *
     * Hint(s):
     *  - check which preferences are used "Support Libraries" vs "AndroidX" (read more about
     *  difference in comment for the [SettingsActivityTest] class). You can check the
     *  /res/xml/root_preferences.xml for understanding which preferences are used in the project.
     *  - check ID of Preferences container (ListView or RecyclerView). The "UiAutomatorViewer"
     *  and "Layout Inspector" can help with it.
     *  - the checking descendant property can done with RecyclerViewMatchers#atPosition ViewMatcher
     *  (can be not implemented yet).
     *  - the preference item often has 2 descends: title and value.
     */
    @Test
    fun shouldMessagesPropertiesHaveDefaultValues() {
        fail()
    }

    /**
     * Test case:
     *  - the "Sync email periodically" has "false" default value
     *  - the "Download incoming attachments" has "false" default value
     *
     * Notes:
     *  - the "Sync email periodically" string can be found in stings.xml file as sync_title const
     *  (R.string.sync_title)
     *  - the "Download incoming attachments" string can be found in strings.xml file as
     *  attachment_title const (R.string.attachment_title)
     *
     * Hint(s):
     *  - check which preferences are used "Support Libraries" vs "AndroidX" (read more about
     *  difference in comment for the [SettingsActivityTest] class). You can check the
     *  /res/xml/root_preferences.xml for understanding which preferences are used in the project.
     *  - check ID of Preferences container (ListView or RecyclerView). The "UiAutomatorViewer"
     *  and "Layout Inspector" can help with it.
     *  - the checking descendant property can done with RecyclerViewMatchers#atPosition ViewMatcher
     *  (can be not implemented yet).
     *  - the preference item often has 2 descends: title and value.
     */
    @Test
    fun shouldSyncPropertiesHaveDefaultValues() {
        fail()
    }

    /**
     * Test case:
     *  - the "Your signature" property has "Not set" default value
     *  - the "Your signature" property has "test" value after changing it in dialog
     *
     * Notes:
     *  - the "Your signature" string can be found in stings.xml file as signature_title const
     *  (R.string.signature_title)
     *
     * Hint(s):
     *  - check which preferences are used "Support Libraries" vs "AndroidX" (read more about
     *  difference in comment for the [SettingsActivityTest] class). You can check the
     *  /res/xml/root_preferences.xml for understanding which preferences are used in the project.
     *  - check ID of Preferences container (ListView or RecyclerView). The "UiAutomatorViewer"
     *  and "Layout Inspector" can help with it.
     *  - the checking descendant property can done with RecyclerViewMatchers#atPosition ViewMatcher
     *  (can be not implemented yet).
     *  - the preference item often has 2 descends: title and value.
     */
    @Test
    fun shouldChangeDefaultValueOfYourSignature() {
        fail()
    }

    /**
     * Test case:
     *  - the "Default reply action" has "Reply" default value
     *  - the "Default reply action" has "Reply to all" value after changing it in dialog
     *
     * Notes:
     *  - the "Default reply action" string can be found in stings.xml file as reply_title const
     *  (R.string.reply_title)
     *  - the "Reply" string can be found in stings.xml file as reply_entity const
     *  (R.string.reply_entity)
     *  - the "Reply to all" string can be found in stings.xml file as reply_to_all_entity const
     *  (R.string.reply_to_all_entity)
     *
     * Hint(s):
     *  - check which preferences are used "Support Libraries" vs "AndroidX" (read more about
     *  difference in comment for the [SettingsActivityTest] class). You can check the
     *  /res/xml/root_preferences.xml for understanding which preferences are used in the project.
     *  - check ID of Preferences container (ListView or RecyclerView). The "UiAutomatorViewer"
     *  and "Layout Inspector" can help with it.
     *  - the checking descendant property can done with RecyclerViewMatchers#atPosition ViewMatcher
     *  (can be not implemented yet).
     *  - the preference item often has 2 descends: title and value.
     */
    @Test
    fun shouldChangeDefaultValueOfDefaultReplyAction() {
        fail()
    }

    /**
     * Test case:
     *  - the "Sync email periodically" has "false" default value
     *  - the "Sync email periodically" has "true" value after changing property
     *
     * Notes:
     *  - the "Sync email periodically" string can be found in stings.xml file as sync_title const
     *  (R.string.sync_title)
     *
     * Hint(s):
     *  - check which preferences are used "Support Libraries" vs "AndroidX" (read more about
     *  difference in comment for the [SettingsActivityTest] class). You can check the
     *  /res/xml/root_preferences.xml for understanding which preferences are used in the project.
     *  - check ID of Preferences container (ListView or RecyclerView). The "UiAutomatorViewer"
     *  and "Layout Inspector" can help with it.
     *  - the checking descendant property can done with RecyclerViewMatchers#atPosition ViewMatcher
     *  (can be not implemented yet).
     *  - the preference item often has 2 descends: title and value.
     */
    @Test
    fun shouldChangeDefaultValueOfSyncEmailPeriodically() {
        fail()
    }

    /**
     * Test case:
     *  - the "Download incoming attachments" is disabled
     *  - the "Download incoming attachments" has "false" default value
     *  - the "Sync email periodically" has "true" value after changing property
     *  - the "Download incoming attachments" enabled after changing "Sync email periodically" to "true"
     *  - the "Download incoming attachments" change value after changing property
     *
     * Notes:
     *  - the "Download incoming attachments" string can be found in stings.xml file as attachment_title const
     *  (R.string.attachment_title)
     *  - the "Sync email periodically" string can be found in stings.xml file as sync_title const
     *  (R.string.sync_title)
     *
     * Hint(s):
     *  - check which preferences are used "Support Libraries" vs "AndroidX" (read more about
     *  difference in comment for the [SettingsActivityTest] class). You can check the
     *  /res/xml/root_preferences.xml for understanding which preferences are used in the project.
     *  - check ID of Preferences container (ListView or RecyclerView). The "UiAutomatorViewer"
     *  and "Layout Inspector" can help with it.
     *  - the checking descendant property can done with RecyclerViewMatchers#atPosition ViewMatcher
     *  (can be not implemented yet).
     *  - the preference item often has 2 descends: title and value.
     */
    @Test
    fun shouldChangeDefaultValueOfDownloadIncomingAttachments() {
        fail()
    }
}
