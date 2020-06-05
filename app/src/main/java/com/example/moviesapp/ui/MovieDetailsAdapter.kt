package com.example.moviesapp.ui

import android.content.ContentValues
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
import kotlinx.android.synthetic.main.detailed_recycler_item.view.*

class MovieDetailsAdapter(private val moviesList : List<Movie>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    class DetailedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

            private val movieImage: ImageView = itemView.movie_image
            private val movieTitle: TextView = itemView.movie_title
            private val movieRate: TextView = itemView.movie_rate_tv
            private val movieOverview: TextView = itemView.movie_overview_tv

            fun bind(movie: Movie){

                movieTitle.text = movie.title
                movieRate.text = movie.vote_average.toString()
                movieOverview.text = movie.overview
                Picasso.get().load("http://image.tmdb.org/t/p/original${movie.poster_path}")
                    .into(movieImage, object : Callback {
                        override fun onSuccess() {
                            Log.e(ContentValues.TAG,"success")
                        }

                        override fun onError(e: java.lang.Exception?) {
                            Log.d(ContentValues.TAG,"error")
                        }
                    })
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DetailedViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.detailed_recycler_item,parent,false))
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is DetailedViewHolder -> holder.bind(moviesList[position])
        }
    }
}