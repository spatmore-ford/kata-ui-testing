package com.ford.uitesting3_mockserver.data

import com.ford.uitesting3_mockserver.data.models.api.Album
import com.ford.uitesting3_mockserver.data.models.domain.AlbumCover
import com.ford.uitesting3_mockserver.data.services.AlbumService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AlbumRepository {

    companion object {
        //        const val baseUrl = "http://jsonplaceholder.typicode.com"
        const val baseUrl = "http://localhost:8080/"

        val okHttpClient: OkHttpClient by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
            OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
        }
    }

    private val service: AlbumService by lazy {
        val client = okHttpClient

        Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
            .create(AlbumService::class.java)
    }

    suspend fun queryAlbumCovers(): List<AlbumCover> {

        return service.fetchAlbums()
            .groupBy(Album::userId)
            .flatMap { mapEntry ->
                val (userId, albums) = mapEntry
                val user = service.fetchUser(userId)
                albums.map { album ->
                    AlbumCover(
                        user = user,
                        album = album,
                        coverPhoto = service.fetchPhoto(album.id).first()
                    )
                }
            }
    }
}

