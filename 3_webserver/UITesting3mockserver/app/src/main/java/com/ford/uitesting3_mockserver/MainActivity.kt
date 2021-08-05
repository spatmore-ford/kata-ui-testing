package com.ford.uitesting3_mockserver

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ford.uitesting3_mockserver.databinding.ActivityMainBinding
import com.ford.uitesting3_mockserver.utils.MarginDecoration

class MainActivity : AppCompatActivity() {

    private val viewModel = AlbumListViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adapter = AlbumAdapter()

        val binding : ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater).apply {
            albumList.adapter = adapter
            albumList.layoutManager = LinearLayoutManager(this@MainActivity)
            albumList.addItemDecoration(MarginDecoration(R.dimen.card_margin, 1))

            setContentView(root)
        }

        viewModel.albums.observe(this, {
            adapter.submitList(it)
            binding.albumList.scheduleLayoutAnimation();
        })
    }
}