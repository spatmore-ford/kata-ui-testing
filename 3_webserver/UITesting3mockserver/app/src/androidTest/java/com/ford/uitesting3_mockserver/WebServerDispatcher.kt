package com.ford.uitesting3_mockserver

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.io.InputStreamReader

object WebServerDispatcher {

    internal class Default : Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse {
            val path = request.path!!
            return when {
                "/albums" in path -> MockResponse().setResponseCode(200).setBody(getJsonContent("albums.json"))
                "/photos" in path -> MockResponse().setResponseCode(200).setBody(getJsonContent("photos.json"))
                "/users" in path -> MockResponse().setResponseCode(200).setBody(getJsonContent("users.json"))
                else -> MockResponse().setResponseCode(400)
            }
        }
    }

    private fun getJsonContent(fileName: String): String {
        return InputStreamReader(this.javaClass.classLoader!!.getResourceAsStream(fileName)).use { it.readText() }
    }
}