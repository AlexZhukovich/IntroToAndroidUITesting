package com.alexzh.testapp.ui.settings

import androidx.appcompat.widget.SwitchCompat
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.alexzh.testapp.R
import com.alexzh.testapp.matchers.RecyclerViewMatchers.atPosition
import com.alexzh.testapp.matchers.ToolbarMatcher.withToolbarTitle
import org.hamcrest.CoreMatchers.*
import org.junit.After
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
 * project is to learn the basics of Espresso framework.
 *
 * You can check I'mBarista project (https://github.com/AlexZhukovich/ImBarista-App) for more complex
 * practices and test cases.
 *
 * The "art/screens-with-views/settings-screen.png" image demonstrates Settings screen with all views
 * and IDs.
 */
@RunWith(AndroidJUnit4::class)
class SettingsActivityTest {

    /**
     * The {@link ActivityTestRule} provides functional testing of a single {@link Activity}.
     * The Espresso framework requires it for launching Activity for testings.
     *
     * We can configure activity before running the test in the following ways:
     *  - Using the {@link #ActivityTestRule(Class, boolean, boolean)}
     *    - first argument *activityClass* - defines the activity that is under test.
     *    - second argument *initialTouchMode* - when set to true, activity will be started in "touch mode".
     *    Touch mode is a state of the UIToolkit that causes the view hierarchy to depend only
     *    on the user interaction. For more information please check:
     *    https://android-developers.googleblog.com/2008/12/touch-mode.html
     *    - third argument *launchActivity* - if this argument is set to true the Activity will be
     *    launched before the test case. Before the set up marked with @Before and closed after
     *    tear down marked with @After. This means we cannot configure it before executing the test case.
     *    If this argument is set to false it is possible to launch the activity with different Intents
     *    per each test method. This is especially useful if we have extras that we want to put in the intent
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
     *  - the [androidx.test.platform.app.InstrumentationRegistry.getInstrumentation] method allows
     *  to get an instrumentation (can be not implemented yet).
     *  object which has access to context of the application.
     *  - the [android.app.Instrumentation.getTargetContext] allows to get a context of the instrumented
     *  application.
     *  - the toolbar title can be checked with [com.alexzh.testapp.matchers.ToolbarMatcher.withToolbarTitle]
     *  ViewMatcher (can be not implemented yet).
     */
    @Test
    fun shouldToolbarContainsSettingsTitle() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val expectedTitle = context.getString(R.string.title_activity_settings)

        onView(withId(R.id.settingsToolbar))
            .check(matches(withToolbarTitle(`is`(expectedTitle))))
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
     *  - the checking descendant property can done with [com.alexzh.testapp.matchers.RecyclerViewMatchers.atPosition]
     *  (can be not implemented yet).
     *  ViewMatcher (can be not implemented yet).
     *  - the preference item often has 2 descends: title and value.
     *  - the [androidx.test.espresso.matcher.ViewMatchers.hasDescendant] matcher allows to match
     *  Matcher<View> to descendants of specified View.
     */
    @Test
    fun shouldMessagesAndSyncCategoriesDisplayed() {
        onView(withId(R.id.recycler_view))
            .check(matches(atPosition(0, hasDescendant(withText(R.string.messages_header)))))
            .check(matches(atPosition(3, hasDescendant(withText(R.string.sync_header)))))
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
     *  - the checking descendant property can done with [com.alexzh.testapp.matchers.RecyclerViewMatchers.atPosition]
     *  (can be not implemented yet).
     *  ViewMatcher (can be not implemented yet).
     *  - the preference item often has 2 descends: title and value.
     */
    @Test
    fun shouldMessagesPropertiesHaveDefaultValues() {
        val signaturePosition = 1
        val defaultReplyActionPosition = 2

        onView(withId(R.id.recycler_view))
            .check(matches(atPosition(signaturePosition, hasDescendant(withText("Not set")))))
            .check(matches(atPosition(defaultReplyActionPosition, hasDescendant(withText(R.string.reply_entity)))))
    }

    /**
     * Test case:
     *  - the "Sync email periodically" has "not checked" default value
     *  - the "Download incoming attachments" has "not checked" default value
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
     *  - the checking descendant property can done with [com.alexzh.testapp.matchers.RecyclerViewMatchers.atPosition]
     *  (can be not implemented yet).
     *  ViewMatcher (can be not implemented yet).
     *  - the preference item often has 2 descends: title and value.
     *  - the [androidx.test.espresso.matcher.ViewMatchers.isChecked] matcher allows to check that
     *  CheckBox, RadioButton, Switch, or other Views are checked.
     *  - the [androidx.test.espresso.matcher.ViewMatchers.hasDescendant] matcher allows to match
     *  Matcher<View> to descendants of specified View.
     *  - the [org.hamcrest.CoreMatchers.instanceOf] method allows to check that View of specified
     *  type.
     *  - the [org.hamcrest.CoreMatchers.allOf] method allows to create a matcher of matchers.
     */
    @Test
    fun shouldSyncPropertiesHaveDefaultValues() {
        val syncEmailPeriodicallyPosition = 4
        val downloadIncomingAttachmentsPosition = 5

        onView(withId(R.id.recycler_view))
            .check(matches(atPosition(syncEmailPeriodicallyPosition, hasDescendant(
                allOf(
                    `is`(instanceOf(SwitchCompat::class.java)),
                    not(isChecked())
                )))))
            .check(matches(atPosition(downloadIncomingAttachmentsPosition, hasDescendant(
                allOf(
                    `is`(instanceOf(SwitchCompat::class.java)),
                    not(isChecked())
                )))))
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
     *   - the checking descendant property can done with [com.alexzh.testapp.matchers.RecyclerViewMatchers.atPosition]
     *  (can be not implemented yet).
     *  ViewMatcher (can be not implemented yet).
     *  - the preference item often has 2 descends: title and value.
     *  - the [androidx.test.espresso.matcher.ViewMatchers.hasDescendant] matcher allows to match
     *  Matcher<View> to descendants of specified View.
     */
    @Test
    fun shouldChangeDefaultValueOfYourSignature() {
        val signaturePosition = 1
        val newValue = "test"

        onView(withId(R.id.recycler_view))
            .check(matches(atPosition(signaturePosition, hasDescendant(withText(R.string.signature_title)))))
            .check(matches(atPosition(signaturePosition, hasDescendant(withText("Not set")))))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(signaturePosition, click()))

        onView(withId(android.R.id.edit))
            .perform(replaceText(newValue))

        onView(withId(android.R.id.button1))
            .perform(click())

        onView(withId(R.id.recycler_view))
            .check(matches(atPosition(signaturePosition, hasDescendant(withText(R.string.signature_title)))))
            .check(matches(atPosition(signaturePosition, hasDescendant(withText(`is`(newValue))))))
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
     *  - the checking descendant property can done with [com.alexzh.testapp.matchers.RecyclerViewMatchers.atPosition]
     *  (can be not implemented yet).
     *  ViewMatcher (can be not implemented yet).
     *  - the preference item often has 2 descends: title and value.
     *  - the [androidx.test.espresso.matcher.ViewMatchers.hasDescendant] matcher allows to match
     *  Matcher<View> to descendants of specified View.
     */
    @Test
    fun shouldChangeDefaultValueOfDefaultReplyAction() {
        val defaultReplyPosition = 2

        onView(withId(R.id.recycler_view))
            .check(matches(atPosition(defaultReplyPosition, hasDescendant(withText(R.string.reply_title)))))
            .check(matches(atPosition(defaultReplyPosition, hasDescendant(withText(R.string.reply_entity)))))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(defaultReplyPosition, click()))

        onView(withText(R.string.reply_to_all_entity))
            .perform(click())

        onView(withId(R.id.recycler_view))
            .check(matches(atPosition(defaultReplyPosition, hasDescendant(withText(R.string.reply_title)))))
            .check(matches(atPosition(defaultReplyPosition, hasDescendant(withText(R.string.reply_to_all_entity)))))
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
     *  - the [androidx.test.espresso.matcher.ViewMatchers.isChecked] matcher allows to check that
     *  CheckBox, RadioButton, Switch, or other Views are checked.
     *  - the [androidx.test.espresso.matcher.ViewMatchers.hasDescendant] matcher allows to match
     *  Matcher<View> to descendants of specified View.
     *  - the [org.hamcrest.CoreMatchers.instanceOf] method allows to check that View of specified
     *  type.
     *  - the [org.hamcrest.CoreMatchers.allOf] method allows to create a matcher of matchers.
     */
    @Test
    fun shouldChangeDefaultValueOfSyncEmailPeriodically() {
        val syncEmailPeriodicallyPosition = 4

        onView(withId(R.id.recycler_view))
            .check(matches(atPosition(syncEmailPeriodicallyPosition, hasDescendant(
                allOf(
                    `is`(instanceOf(SwitchCompat::class.java)),
                    not(isChecked())
                )))))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(syncEmailPeriodicallyPosition, click()))
            .check(matches(atPosition(syncEmailPeriodicallyPosition, hasDescendant(
                allOf(
                    `is`(instanceOf(SwitchCompat::class.java)),
                    isChecked()
                )))))
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
     *  - the [androidx.test.espresso.matcher.ViewMatchers.isEnabled] matcher allow to check that
     *  View is enabled.
     *  - the [androidx.test.espresso.matcher.ViewMatchers.isChecked] matcher allows to check that
     *  CheckBox, RadioButton, Switch, or other Views are checked.
     *  - the [androidx.test.espresso.matcher.ViewMatchers.hasDescendant] matcher allows to match
     *  Matcher<View> to descendants of specified View.
     *  - the [org.hamcrest.CoreMatchers.instanceOf] method allows to check that View of specified
     *  type.
     *  - the [org.hamcrest.CoreMatchers.allOf] method allows to create a matcher of matchers.
     */
    @Test
    fun shouldChangeDefaultValueOfDownloadIncomingAttachments() {
        val syncEmailPeriodicallyPosition = 4
        val downloadIncomingAttachmentsPosition = 5

        onView(withId(R.id.recycler_view))
            .check(matches(atPosition(downloadIncomingAttachmentsPosition, hasDescendant(
                allOf(
                    `is`(instanceOf(SwitchCompat::class.java)),
                    not(isEnabled())
                )))))
            .check(matches(atPosition(downloadIncomingAttachmentsPosition, hasDescendant(
                allOf(
                    `is`(instanceOf(SwitchCompat::class.java)),
                    not(isChecked())
                )))))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(syncEmailPeriodicallyPosition, click()))
            .check(matches(atPosition(downloadIncomingAttachmentsPosition, hasDescendant(
                allOf(
                    `is`(instanceOf(SwitchCompat::class.java)),
                    isEnabled()
                )))))
            .check(matches(atPosition(downloadIncomingAttachmentsPosition, hasDescendant(
                allOf(
                    `is`(instanceOf(SwitchCompat::class.java)),
                    not(isChecked())
                )))))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(downloadIncomingAttachmentsPosition, click()))
            .check(matches(atPosition(downloadIncomingAttachmentsPosition, hasDescendant(
                allOf(
                    `is`(instanceOf(SwitchCompat::class.java)),
                    isChecked()
                )))))
    }

    @After
    fun tearDown() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().clear().commit()
    }
}
