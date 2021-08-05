package com.ford.uitesting3_mockserver.data.services

import com.ford.uitesting3_mockserver.data.models.api.Album
import com.ford.uitesting3_mockserver.data.models.api.Photo
import com.ford.uitesting3_mockserver.data.models.api.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AlbumService {

    @GET("/albums")
    suspend fun fetchAlbums(): List<Album>

    @GET("/users/{userId}")
    suspend fun fetchUser(@Path("userId") userId: Int): User

    @GET("/photos")
    suspend fun fetchPhoto(@Query("albumId") albumId: Int): List<Photo>
}