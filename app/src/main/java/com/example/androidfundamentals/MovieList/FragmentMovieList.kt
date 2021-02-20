package com.example.androidfundamentals.MovieList

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfundamentals.MovieDetails.FragmentMovieDetails
import com.example.androidfundamentals.R
import com.example.androidfundamentals.TransactionClickListener
import com.example.androidfundamentals.data.Movie
import com.example.androidfundamentals.data.loadMovies
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FragmentMovieList : Fragment() {

    private var listener: TransactionClickListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val scope = CoroutineScope(Dispatchers.IO)
        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)
        val movieList: RecyclerView = view.findViewById(R.id.movie_list)
        var movies: List<Movie>
        var adapter: MovieListAdapter
        scope.launch {
            movies = loadMovies(movieList.context)
            adapter = MovieListAdapter(movieList.context, movies, listener!!)
            movieList.post {
                movieList.adapter = adapter
            }
        }
        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            movieList.layoutManager = GridLayoutManager(this.context, 2)
        }
        else{
            movieList.layoutManager = GridLayoutManager(this.context, 4)
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
        fun newInstance(): FragmentMovieList {
            val fragment = FragmentMovieList()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}