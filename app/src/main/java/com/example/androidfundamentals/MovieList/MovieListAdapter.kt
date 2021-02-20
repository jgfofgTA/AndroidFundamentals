package com.example.androidfundamentals.MovieList

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfundamentals.R
import com.example.androidfundamentals.TransactionClickListener
import com.example.androidfundamentals.data.Movie

class MovieListAdapter(var context: Context, var movies: List<Movie>, private var listener: TransactionClickListener) : RecyclerView.Adapter<MovieListViewHolder>() {

    private val inflater:LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        return MovieListViewHolder(inflater.inflate(R.layout.view_holder_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    override fun getItemCount(): Int = movies.size

    fun getItem(position: Int): Movie = movies[position]
}