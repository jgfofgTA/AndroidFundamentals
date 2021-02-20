package com.example.androidfundamentals

import android.os.Parcelable
import com.example.androidfundamentals.data.Actor

interface TransactionClickListener {
    fun addMovieDetails(dataMovieDetails: Parcelable)
    fun addMovieList()
}