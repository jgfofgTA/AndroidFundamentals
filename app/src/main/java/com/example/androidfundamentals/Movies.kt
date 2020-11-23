package com.example.androidfundamentals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView


class Movies : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movies)
        val avengers: CardView = findViewById(R.id.avengers)
        avengers.setOnClickListener {
            val intent = Intent(this, MovieDetails::class.java)
            startActivity(intent)
        }
    }
}