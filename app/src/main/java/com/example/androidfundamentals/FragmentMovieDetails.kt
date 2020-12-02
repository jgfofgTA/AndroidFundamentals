package com.example.androidfundamentals

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class FragmentMovieDetails : Fragment() {

    private var back : ImageView? = null
    private var listener: TransactionClickListener? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_details, container, false)
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
        fun newInstance(): FragmentMovieDetails {
            val fragment = FragmentMovieDetails()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}