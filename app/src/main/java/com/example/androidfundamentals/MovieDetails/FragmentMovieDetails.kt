package com.example.androidfundamentals.MovieDetails

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidfundamentals.MovieList.MovieListViewHolder
import com.example.androidfundamentals.R
import com.example.androidfundamentals.TransactionClickListener
import com.example.androidfundamentals.data.Actor

class FragmentMovieDetails : Fragment() {

    private var back : ImageView? = null
    private var listener: TransactionClickListener? = null

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_details, container, false)
        val movieDetailsActorsList: RecyclerView = view.findViewById(R.id.actorsList)
        var actors: List<Actor>? = null
        val titleText: TextView = view.findViewById(R.id.movie_details_title_text)
        val movieDetailsPg: TextView = view.findViewById(R.id.movie_details_pg)
        val mask: ImageView = view.findViewById(R.id.movie_details_mask)
        val movieDetailsTag: TextView = view.findViewById(R.id.movie_details_tag)
        val movieDetailsReviews: TextView = view.findViewById(R.id.movie_details_reviews)
        val movieDetailsStars: RatingBar = view.findViewById(R.id.movie_details_stars)
        val movieDetailsStoryline: TextView = view.findViewById(R.id.movie_details_storyline_text)
        val dataMovieDetails = args.getParcelable<MovieListViewHolder.DataMovieDetails>("data_movie_details")
        titleText.text = dataMovieDetails?.titleText
        movieDetailsPg.text = "+${dataMovieDetails?.movieDetailsPg}"
        Glide
            .with(mask.context)
            .load(dataMovieDetails?.mask)
            .into(mask)
        movieDetailsTag.text = dataMovieDetails?.movieDetailsTag
        movieDetailsReviews.text = "${dataMovieDetails?.movieDetailsReviews} REVIEWS"
        movieDetailsStars.rating = dataMovieDetails?.movieDetailsStars!!
        movieDetailsStoryline.text = dataMovieDetails.movieDetailsStoryline
        actors = dataMovieDetails.actors as List<Actor>
        val adapter = MovieDetailsActorsAdapter(this.requireContext(), actors)
        movieDetailsActorsList.adapter = adapter
        movieDetailsActorsList.layoutManager = LinearLayoutManager(this.context, RecyclerView.HORIZONTAL, false)
        back = view.findViewById<ImageView>(R.id.back).apply {
            setOnClickListener { listener?.addMovieList() }
        }
        return view
    }


    fun setClickListener(l: TransactionClickListener?) {
        listener = l
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is TransactionClickListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        val args = Bundle()
        fun newInstance(dataMovieDetails: Parcelable): FragmentMovieDetails {
            val fragment = FragmentMovieDetails()
            args.putParcelable("data_movie_details", dataMovieDetails)
            fragment.arguments = args
            return fragment
        }
    }
}