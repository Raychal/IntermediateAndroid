package com.example.intermediateandroid.ui.list

import android.support.test.espresso.contrib.RecyclerViewActions.*
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.ViewAction
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.intermediateandroid.R
import com.example.intermediateandroid.ui.detail.NewsDetailActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.example.intermediateandroid.utils.EspressoIdlingResource


@RunWith(AndroidJUnit4::class)
@LargeTest
class HomeActivityTest{

    @get:Rule
    val activity = ActivityScenarioRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
    }

    @Test
    fun loadHeadlineNews_Success() {
        onView(withId(R.id.rv_news)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_news)).perform(scrollToPosition<ViewHolder>(10))
    }
    @Test
    fun loadDetailNews_Success() {
        Intents.init()
        onView(withId(R.id.rv_news)).perform(actionOnItemAtPosition<ViewHolder>(0, click()))
        intended(hasComponent(NewsDetailActivity::class.java.name))
        onView(withId(R.id.webView)).check(matches(isDisplayed()))
    }
    @Test
    fun loadBookmarkedNews_Success() {
        onView(withId(R.id.rv_news)).perform(actionOnItemAtPosition<ViewHolder>(0, click()))
        onView(withId(R.id.action_bookmark)).perform(click())
        pressBack()
        onView(withText("BOOKMARK")).perform(click())
        onView(withId(R.id.rv_news)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_news)).perform(actionOnItemAtPosition<ViewHolder>(0, click()))
        onView(withId(R.id.webView)).check(matches(isDisplayed()))
        onView(withId(R.id.action_bookmark)).perform(click())
        pressBack()
    }
}