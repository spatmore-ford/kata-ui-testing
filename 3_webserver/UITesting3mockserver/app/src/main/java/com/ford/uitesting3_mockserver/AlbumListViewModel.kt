package com.ford.uitesting3_mockserver

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ford.uitesting3_mockserver.data.AlbumRepository
import com.ford.uitesting3_mockserver.data.models.domain.AlbumCover

class AlbumListViewModel : ViewModel() {

    private val repository = AlbumRepository()

    val albums: LiveData<List<AlbumCover>> by lazy {
        liveData {
            emit(repository.queryAlbumCovers())
        }
    }
}