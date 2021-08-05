package com.ford.uitesting1_text

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import com.ford.uitesting1_text.databinding.ActivityPetBinding

class PetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPetBinding.inflate(layoutInflater)
        binding.submit.setOnClickListener {
            startActivity(
                Intent(this, FamilyActivity::class.java)
                    .putExtras(intent)
                    .putExtra("dog", binding.dogsName.text.toString())
            )
        }

        binding.dogsName.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                binding.submit.callOnClick()
            } else {
                false
            }
        }
        binding.dogsName.requestFocus()

        setContentView(binding.root)
    }
}