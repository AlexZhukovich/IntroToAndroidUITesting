package com.alexzh.testapp.ui.home

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
import com.alexzh.testapp.actions.RecyclerViewActions.clickByChildViewWithId
import com.alexzh.testapp.data.DummyData
import com.alexzh.testapp.matchers.RecyclerViewMatchers.atPosition
import com.alexzh.testapp.matchers.RecyclerViewMatchers.withItemCount
import com.alexzh.testapp.matchers.ToolbarMatcher.withToolbarTitle
import com.alexzh.testapp.ui.home.adapter.TaskViewHolder
import com.alexzh.testapp.ui.settings.SettingsActivity
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.not
import org.junit.Assert
import org.junit.Assert.fail
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    @Test
    fun shouldToolbarContainsTextAppTitle() {
        fail()
    }

    @Test
    fun shouldRecyclerViewHas15Items() {
        fail()
    }

    @Test
    fun shouldOpenSettingsScreenWhenSettingsItemClicked() {
        fail()
    }

    @Test
    fun shouldBeDisplayedTaskTitleWhenClickOnTask() {
        fail()
    }

    @Test
    fun shouldBeDisplayTaskInfoWhenClickedOnFavouriteIcon() {
        fail()
    }

    @Test
    fun shouldFirstTestItemIsFavourite() {
        fail()
    }

    @Test
    fun shouldTenthTestItemIsNotFavourite() {
        fail()
    }
}