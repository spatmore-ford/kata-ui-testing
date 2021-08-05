package com.ford.uitesting3_mockserver

import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ford.idlingResource.OkHttp3IdlingResource
import com.ford.uitesting3_mockserver.data.AlbumRepository.Companion.okHttpClient
import com.ford.viewMatchers.recyclerHasItemCount
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleAlbumListText {

    @get:Rule
    val scenarioRule = ActivityScenarioRule(MainActivity::class.java)

    private val mockWebServer = MockWebServer()

    @Before
    fun setUp() {
        mockWebServer.start(8080)
        mockWebServer.dispatcher = WebServerDispatcher.Default()
        
        val create: IdlingResource = OkHttp3IdlingResource.create("okhttp", okHttpClient)
        IdlingRegistry.getInstance().register(create)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun number_of_items_in_list() {
        Espresso.onView(withId(R.id.album_list)).check(recyclerHasItemCount(1))
    }
}