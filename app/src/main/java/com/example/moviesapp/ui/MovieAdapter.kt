package com.example.moviesapp.ui
import android.content.ContentValues.TAG
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.moviesapp.R
import com.example.moviesapp.pojo.Movie
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_item.view.*

class MovieAdapter(private val moviesList : List<Movie>) :
    RecyclerView.Adapter<ViewHolder>() {

    class MovieViewHolder(itemView: View) : ViewHolder(itemView) {

        private val movieImage: ImageView = itemView.imageView
        private val movieTitle: TextView = itemView.textView
        private val movieRate: TextView = itemView.movie_rate

        fun bind(movie: Movie){

            movieTitle.text = movie.title
            movieRate.text = movie.vote_average.toString()
            Picasso.get().load("http://image.tmdb.org/t/p/original${movie.poster_path}")
                .into(movieImage, object : Callback {
                    override fun onSuccess() {
                        Log.d(TAG, "success")
                    }

                    override fun onError(e: Exception?) {
                        Log.d(TAG, "error")
                    }
                })
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val movieViewHolder = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return MovieViewHolder(movieViewHolder)
    }

    override fun getItemCount(): Int {
            return moviesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(holder){
            is MovieViewHolder -> {
                holder.bind(moviesList[position])
                holder.itemView.setOnClickListener {
                    val intent = Intent(holder.itemView.context,MovieDetailsActivity::class.java)
                    intent.putExtra("currentPosition",holder.adapterPosition)
                    holder.itemView.context.startActivity(intent)
                }
            }
        }
    }
    fun getAdapterPosition(): Int{

    }
}
