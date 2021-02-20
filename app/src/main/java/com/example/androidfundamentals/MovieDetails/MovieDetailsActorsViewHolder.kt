package com.example.androidfundamentals.MovieDetails

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidfundamentals.R
import com.example.androidfundamentals.data.Actor

class MovieDetailsActorsViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val avatar: ImageView = view.findViewById(R.id.avatar)
    private val actor: TextView = view.findViewById(R.id.actor)

    fun bind(actors: Actor) {
        Glide
                .with(avatar.context)
                .load(actors.picture)
                .into(avatar)
        actor.text = actors.name
    }
}