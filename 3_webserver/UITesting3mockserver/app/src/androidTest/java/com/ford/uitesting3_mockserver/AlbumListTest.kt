package com.ford.uitesting3_mockserver

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AlbumListTest {

    @get:Rule
    val scenarioRule = ActivityScenarioRule(MainActivity::class.java)

    /**
     * Task 1: Write a test to verify the correct number of values are displayed in the list
     */
    @Test
    fun number_of_items_in_list() {
    }

    /**
     * Task 2: Write a test to verify the appropriate user is loaded for each album
     */
    @Test
    fun correct_user_requested_for_album() {
    }
}