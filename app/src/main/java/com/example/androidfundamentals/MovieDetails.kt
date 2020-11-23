package com.example.androidfundamentals

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MovieDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_details)
        val back: ImageView = findViewById(R.id.back)
        back.setOnClickListener {
            finish()
        }
    }
}