package com.ford.uitesting1_text

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ford.uitesting1_text.databinding.ActivityFamilyBinding

class FamilyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFamilyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFamilyBinding.inflate(layoutInflater)
        binding.sentence.text = resources.getString(R.string.family_message, intent.getStringExtra("user"), intent.getStringExtra("dog"))

        setContentView(binding.root)
    }
}