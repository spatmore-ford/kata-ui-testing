package com.ford.uitesting1_text

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import com.ford.uitesting1_text.databinding.ActivityUsernameBinding

class UsernameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUsernameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUsernameBinding.inflate(layoutInflater)
        binding.submit.setOnClickListener {
            startActivity(
                Intent(this, PetActivity::class.java)
                    .putExtra("user", binding.usersName.text.toString())
            )
        }

        binding.usersName.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                binding.submit.callOnClick()
            } else {
                false
            }
        }

        binding.usersName.requestFocus()

        setContentView(binding.root)
    }
}