package com.ford.uitesting3_mockserver

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.ford.uitesting3_mockserver.data.models.domain.AlbumCover
import com.ford.uitesting3_mockserver.databinding.ListItemAlbumBinding

class AlbumAdapter : ListAdapter<AlbumCover, AlbumAdapter.AlbumViewHolder>(Diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class AlbumViewHolder(private val binding: ListItemAlbumBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(albumCover: AlbumCover) {
            binding.albumTitle.text = albumCover.albumTitle
            binding.ownerName.text = albumCover.username

            val glide = Glide.with(binding.root)

            glide.load(albumCover.userImage)
                .circleCrop()
                .into(binding.ownerImage)

            glide.load(GlideUrl(albumCover.coverImage, LazyHeaders.Builder().addHeader("User-Agent", "").build()))
                .centerCrop()
                .into(binding.albumImage)
        }

        companion object {
            fun create(parent: ViewGroup): AlbumViewHolder {
                return AlbumViewHolder(ListItemAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
        }
    }

    object Diff : DiffUtil.ItemCallback<AlbumCover>() {
        override fun areItemsTheSame(oldItem: AlbumCover, newItem: AlbumCover): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: AlbumCover, newItem: AlbumCover): Boolean = oldItem == newItem
    }
}