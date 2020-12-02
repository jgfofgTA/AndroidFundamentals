package com.example.androidfundamentals

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class FragmentMovieList : Fragment() {


    private var avengers : CardView? = null
    private var listener: TransactionClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)
        avengers = view.findViewById<CardView>(R.id.avengers).apply {
            setOnClickListener { listener?.addMovieDetails() }
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