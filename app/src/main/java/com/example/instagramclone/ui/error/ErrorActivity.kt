package com.example.instagramclone.ui.error

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.instagramclone.databinding.ActivityErrorBinding
import com.example.instagramclone.ui.MainActivity

class ErrorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityErrorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityErrorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cause = intent.extras?.getString(INTENT_KEY_CAUSE)
        binding.textViewErrorCause.text = cause

        binding.swipeRefreshError.setOnRefreshListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        const val INTENT_KEY_CAUSE = "cause"
    }
}