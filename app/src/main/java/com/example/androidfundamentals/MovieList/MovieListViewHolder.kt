package com.example.androidfundamentals.MovieList

import android.annotation.SuppressLint
import android.os.Parcelable
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidfundamentals.R
import com.example.androidfundamentals.TransactionClickListener
import com.example.androidfundamentals.data.Movie
import kotlinx.parcelize.Parcelize

class MovieListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    @Parcelize
    data class DataMovieDetails(
            val titleText: String,
            val movieDetailsPg: Int,
            val mask: String,
            val movieDetailsTag: String,
            val movieDetailsReviews: Int,
            val movieDetailsStars: Float,
            val movieDetailsStoryline: String,
            var actors: List<Parcelable>
    ) : Parcelable
    private val maskAndMovie: ImageView = view.findViewById(R.id.mask_and_movie)
    private val like: ImageView = view.findViewById(R.id.like)
    private val pg: TextView = view.findViewById(R.id.pg)
    private val stars: RatingBar = view.findViewById(R.id.stars)
    private val name: TextView = view.findViewById(R.id.name)
    private val time: TextView = view.findViewById(R.id.time)
    private val tag: TextView = view.findViewById(R.id.tag)
    private val reviews: TextView = view.findViewById(R.id.reviews)
    private var string: String = ""
    private val cardView: CardView = view.findViewById(R.id.cardView)
    @SuppressLint("SetTextI18n")
    fun bind(movie: Movie, listener: TransactionClickListener) {
        Glide
            .with(maskAndMovie.context)
            .load(movie.poster)
            .into(maskAndMovie)
        name.text = movie.title
        pg.text = "+${movie.minimumAge}"
        stars.rating = movie.ratings/2
        time.text = "${movie.runtime} MIN"
        for(element in movie.genres) {
            string += "${element.name} "
        }
        tag.text = string
        string = ""
        reviews.text = "${movie.numberOfRatings} REVIEWS"
        cardView.setOnClickListener {
            listener.addMovieDetails(DataMovieDetails(
                    movie.title,
                    movie.minimumAge,
                    movie.backdrop,
                    tag.text.toString(),
                    movie.numberOfRatings,
                    movie.ratings,
                    movie.overview,
                    movie.actors as List<Parcelable>
            ))
        }
    }
}