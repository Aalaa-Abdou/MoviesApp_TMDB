package com.example.moviesapp.ui

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.pojo.Movie
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_item.view.*

class MovieAdapter(private val moviesList : List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {


    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val movieImage : ImageView = itemView.imageView
        val movieTitle : TextView = itemView.textView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val movieView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return MovieViewHolder(movieView)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie: Movie = moviesList[position]
        holder.movieTitle.text = movie.title
        Picasso.get().load("http://image.tmdb.org/t/p/w500${movie.poster_path}").into(holder.movieImage, object : Callback {
                override fun onSuccess() {
                    Log.d(TAG, "success")
                }

                override fun onError(e: Exception?) {
                    Log.d(TAG, "error")
                }
            })


    }

}