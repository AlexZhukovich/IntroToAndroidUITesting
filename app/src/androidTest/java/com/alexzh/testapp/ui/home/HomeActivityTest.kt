package com.alexzh.testapp.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.alexzh.testapp.R
import com.alexzh.testapp.data.DummyData
import com.alexzh.testapp.matchers.RecyclerViewMatchers.withItemCount
import com.alexzh.testapp.matchers.ToolbarMatcher.withToolbarTitle
import com.alexzh.testapp.ui.settings.SettingsActivity
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.fail
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Test suite for checking the HomeActivity class from a UI perspective.
 *
 * Note:
 * This class can be run without any pre-requirements.
 * The HomeActivity class doesn't verify if the User is logged in because the main idea of the project
 * is to learn the basics of Espresso framework.
 *
 * You can check I'mBarista project (https://github.com/AlexZhukovich/ImBarista-App) for more complex
 * practices and test cases.
 *
 * The "art/screens-with-views/home-screen.png" image demonstrates Home screen with all views
 * and IDs.
 */
@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    /**
     * The {@link ActivityTestRule} provides functional testing of a single {@link Activity}.
     * The Espresso framework requires it for launching Activity for testings.
     *
     * We can configure activity before running the test in the following ways:
     *  - Using the {@link #ActivityTestRule(Class, boolean, boolean)}
     *  {@link #ActivityTestRule(Class, boolean, boolean)}
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
    val activity = ActivityTestRule(HomeActivity::class.java)

    /**
     * Test case:
     *  - HomeActivity should have options menu
     *  - "Settings" menu item should be displayed in options menu
     *
     * Notes:
     *  - the "Settings" text can be found in strings.xml file as settings_action const
     *  (R.string.settings_action)
     *
     * Hint(s):
     *  - the Espresso#openActionBarOverflowOrOptionsMenu method allows us to open options menu.
     */
    @Test
    fun shouldOptionsMenuHasSettingsItem() {
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getInstrumentation().targetContext)

        onView(withText(R.string.settings_action))
            .check(matches(isDisplayed()))
    }

    /**
     * Test case:
     *  - HomeActivity should have options menu
     *  - SettingsActivity should be opened after pressing on "Settings" in options menu
     *
     * Notes:
     *  - the "Settings" text can be found in strings.xml file as settings_action const
     *  (R.string.settings_action)
     *
     * Hint(s):
     *  - Intent.intended(IntentMatcher) allows us to verify that Activity was opened.
     *  The Intents component should be initialized before using with the Intents#init() method
     *  and released when it's not needed with the Intents#release() method. As an alternative
     *  we can use IntentsTestRule, which initializes Espresso-Intents before each test annotated
     *  with Test and releases Espresso-Intents after each test run.
     *  - the Espresso#openActionBarOverflowOrOptionsMenu method allows us to open options menu.
     */
    @Test
    fun shouldOpenSettingsScreenWhenSettingsItemClicked() {
        Intents.init()

        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getInstrumentation().targetContext)
        onView(withText(R.string.settings_action))
            .perform(click())

        Intents.intended(IntentMatchers.hasComponent(SettingsActivity::class.java.name))
        Intents.release()
    }

    /**
     * Test case:
     *  - the task title should be displayed after click on item from RecyclerView
     *
     * Notes:
     *  - the "RecyclerView" has ID: recyclerView (R.id.recyclerView)
     *  - the "RecyclerView" shows items created in DummyData#getTasks() method
     *  - the error message with the same text as Task title is displayed
     *
     * Hint(s):
     *  - the action on item can be made with RecyclerViewActions#actionOnItem method.
     *  - the task can be got from DummyData#getTasks() by position use `DummyData.getTasks()[ POSITION ]`
     *  - the title of the task can be got from title property `task.title`
     *  - the Snackbar view has error message
     *  - the Snackbar text message view has ID: snackbar_text (com.google.android.material.R.id.snackbar_text)
     *
     */
    @Test
    fun shouldBeDisplayedTaskTitleWhenClickOnTask() {
        val position = 0
        val expectedText = DummyData.getTasks()[position].title

        onView(withId(R.id.recyclerView))
            .perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(position, click()))

        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText(expectedText)))
    }

    /**
     * Test case:
     *  - Toolbar should have a text "TestApp"
     *
     * Notes:
     *  - the "Toolbar" view has ID: homeToolbar (R.id.homeToolbar)
     *  - the "TestApp" string can be found in strings.xml file as app_name const (R.string.app_name)
     *
     * Hint(s):
     *  - the toolbar title can be checked with ToolbarMatcher#withToolbarTitle ViewMatcher
     *  (can be not implemented yet).
     */
    @Test
    fun shouldToolbarContainsTextAppTitle() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val expectedTitle = context.getString(R.string.app_name)

        onView(withId(R.id.homeToolbar))
            .check(matches(withToolbarTitle(`is`(expectedTitle))))
    }

    /**
     * Test case:
     *  - RecyclerView should have 45 items by default
     *  - Number of tasks can be changed in [com.alexzh.testapp.data.DummyData.TASK_COUNT] const
     *
     * Notes:
     *  - the "RecyclerView" has ID: recyclerView (R.id.recyclerView)
     *  - the "RecyclerView" shows items created in DummyData#getTasks() method
     *
     * Hint(s):
     *  - the number of items in RecyclerView can be checked with RecyclerViewMatchers#withItemCount
     *  ViewMatcher (can be not implemented yet).
     *  - the number of visible items depends on the screen. If you want to do action with invisible
     *  on screen item you should scroll to this item first, you can use the following actions:
     *    - RecyclerViewActions#scrollTo(itemMatcher)
     *    - RecyclerViewActions#scrollToHolder(viewHolderMatcher)
     *    - RecyclerViewActions#scrollToPosition(position)
     */
    @Test
    fun shouldRecyclerViewHas45Items() {
        onView(withId(R.id.recyclerView))
            .check(matches(withItemCount(DummyData.getTasks().size)))
    }

    /**
     * Test case:
     *  - the "The {task title} task is favourite" or "The {task title} task is not favourite" text
     *  should be displayed in Snackbar after click on favourite icon of the item, depends on
     *  the status of the item.
     *
     * Notes:
     *  - the data displayed in the RecyclerView can found in DummyData#getTasks() method.
     *  - the "The {task title} task is favourite" string can be found in string.xml file as
     *  formatted_favourite_task const (R.string.formatted_favourite_task).
     *  - the "The {task title} task is not favourite" string can be found in string.xml file as
     *  formatted_not_favourite_task const (R.string.formatted_not_favourite_task).
     *  - the Snackbar component displays text which can be found in view with ID: snackbar_text
     *  (com.google.android.material.R.id.snackbar_text).
     *
     * Hint(s):
     *  - the click on child item, like favourite icon can be made with
     *  RecyclerViewActions#clickByChildViewWithId ViewAction (can be not implemented yet).
     */
    @Test
    fun shouldBeDisplayTaskInfoWhenClickedOnFavouriteIcon() {
        fail()
    }

    /**
     * Test case:
     *  - the first task should be favourite. We can verify it by verification ViewHolder of the
     *  task. Each item has two descendants: title and icon.
     *
     * Notes:
     *  - the view with ID: favouriteImageView (R.id.favouriteImageView) displays the drawable
     *  with ID: ic_favorite_black_24dp (R.drawable.ic_favorite_black_24dp) when task is favourite.
     *  - the data displayed in the RecyclerView can found in DummyData#getTasks() method.
     *  - comparing rendered image with image from drawable file is very inefficient because image
     *  can be resized or rendered from vector image. As an alternative we can use the TAG attribute
     *  and set TAG as a file name of used resource.
     *  - the "RecyclerView" has ID: recyclerView (R.id.recyclerView).
     *
     * Hint(s):
     *  - the checking descendant property can done with RecyclerViewMatchers#atPosition ViewMatcher
     *  (can be not implemented yet).
     */
    @Test
    fun shouldFirstTestItemIsFavourite() {
        fail()
    }

    /**
     * Test case:
     *  - the lat task should be not favourite. We can verify it by verification ViewHolder of the
     *  task. Each item has two descendants: title and icon.
     *
     * Note:
     *  - the view with ID: favouriteImageView (R.id.favouriteImageView) displays the drawable
     *  with ID: ic_favorite_border_black_24dp (R.drawable.ic_favorite_border_black_24dp) when task
     *  is not favourite.
     *  - the data displayed in the RecyclerView can found in DummyData#getTasks() method.
     *  - comparing rendered image with image from drawable file is very inefficient because image
     *  can be resized or rendered from vector image. As an alternative we can use the TAG attribute
     *  and set TAG as a file name of used resource.
     *  - the "RecyclerView" has ID: recyclerView (R.id.recyclerView).
     *
     * Hint(s):
     *  - the checking descendant property can done with RecyclerViewMatchers#atPosition ViewMatcher
     * (can be not implemented yet).
     *  - the number of visible items depends on the screen. If you want to do action with invisible
     *  on screen item you should scroll to this item first, you can use the following actions:
     *    - RecyclerViewActions#scrollTo(itemMatcher)
     *    - RecyclerViewActions#scrollToHolder(viewHolderMatcher)
     *    - RecyclerViewActions#scrollToPosition(position)
     */
    @Test
    fun shouldLastTestItemIsNotFavourite() {
       fail()
    }
}
