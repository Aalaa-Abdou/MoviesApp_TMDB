package com.example.moviesapp.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.pojo.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_item.view.*

class MovieAdapter(private val moviesList : List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {




    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val movieImage : ImageView = itemView.imageView
        val movieTitle : TextView = itemView.textView
        init {
            itemView.setOnClickListener {
                val intent = Intent(itemView.context,MovieDetailsActivity::class.java)
                intent.putExtra("MOVIE_TITLE",moviesList[adapterPosition].title)
                intent.putExtra("MOVIE_IMAGE", moviesList[adapterPosition].poster_path)
            }
        }
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
        Picasso.get().load(movie.poster_path).into(holder.movieImage)

    }

}