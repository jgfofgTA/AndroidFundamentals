package com.example.androidfundamentals

import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.example.androidfundamentals.MovieDetails.FragmentMovieDetails
import com.example.androidfundamentals.MovieList.FragmentMovieList
import com.example.androidfundamentals.data.Actor

class MainActivity : AppCompatActivity(), TransactionClickListener{

    private val fragmentMovieList = FragmentMovieList().apply { setClickListener(this@MainActivity) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .apply {
                        add(R.id.frame_layout_activity_main, fragmentMovieList)
                        commit()
                    }
        }
    }

    override fun addMovieList() {
        supportFragmentManager.beginTransaction()
                .apply {
                    onBackPressed()
                    commit()
                }
    }

    override fun addMovieDetails(dataMovieDetails: Parcelable) {
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.frame_layout_activity_main, FragmentMovieDetails.newInstance(dataMovieDetails))
                addToBackStack(null)
                commit()
            }
    }
}