package com.ford.uitesting3_mockserver.data.models.domain

import com.ford.uitesting3_mockserver.data.models.api.Album
import com.ford.uitesting3_mockserver.data.models.api.Photo
import com.ford.uitesting3_mockserver.data.models.api.User

data class AlbumCover(
    private val album: Album,
    private val user: User,
    private val coverPhoto: Photo,
) {

    val id: Int get() = album.id
    val albumTitle: String get() = album.title
    val username: String get() = user.name
    val userImage: String get() = "https://i.pravatar.cc/150?u=${album.userId}"
    val coverImage: String get() = coverPhoto.thumbnailUrl
}