package com.example.androidfundamentals.MovieDetails

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfundamentals.R
import com.example.androidfundamentals.data.Actor

class MovieDetailsActorsAdapter(var context: Context, var actors: List<Actor>): RecyclerView.Adapter<MovieDetailsActorsViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieDetailsActorsViewHolder {
        return MovieDetailsActorsViewHolder(inflater.inflate(R.layout.view_holder_movie_details_actor, parent, false))
    }

    override fun onBindViewHolder(holder: MovieDetailsActorsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int = actors.size

    fun getItem(position: Int): Actor= actors[position]
}