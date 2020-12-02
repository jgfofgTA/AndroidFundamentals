package com.example.androidfundamentals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), TransactionClickListener {

    private val fragmentMovieList = FragmentMovieList().apply { setClickListener(this@MainActivity) }
    private val fragmentMovieDetails = FragmentMovieDetails().apply { setClickListener(this@MainActivity) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .apply {
                        add(R.id.frame_layout_activity_main, fragmentMovieList)
                        addToBackStack(null)
                        commit()
                    }
        }
    }

    override fun addMovieDetails() {
        supportFragmentManager.beginTransaction()
                .apply {
                    replace(R.id.frame_layout_activity_main, FragmentMovieDetails.newInstance())
                    addToBackStack(null)
                    commit()
                }
    }

    override fun addMovieList() {
        supportFragmentManager.beginTransaction()
                .apply {
                    replace(R.id.frame_layout_activity_main, FragmentMovieList.newInstance())
                    addToBackStack(null)
                    commit()
                }
    }
}