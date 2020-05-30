package com.example.moviesapp.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.data.ApiInterface
import com.example.moviesapp.data.MovieRepository
import com.example.moviesapp.pojo.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {

    var sortBy: String = "popularity.desc"
    lateinit var apiInterface: ApiInterface



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callingApi(sortBy)

        popular.setOnClickListener(this)
        latest.setOnClickListener(this)
    }

    fun callingApi(sortBy: String){
        MovieRepository.showingData(object :
            MoviesCallBack {
            override fun onMovieLoaded(Movies: List<Movie>) {
                populateMoviesRecycler(Movies)
            }
        }, sortBy)
    }

    private fun populateMoviesRecycler(movieList : List<Movie>){

        recycler_view.layoutManager = GridLayoutManager(this,2)

        recycler_view.adapter = MovieAdapter(movieList)

    }



    override fun onClick(v: View?) {
        when(v?.id){
            R.id.popular -> {
                sortBy="popularity.desc"
                latest.setTextColor(Color.GRAY)
                popular.setTextColor(Color.WHITE)
                view_latest.visibility = View.INVISIBLE
                view_popular.visibility = View.VISIBLE
                callingApi(sortBy)
            }
            R.id.latest -> {
                sortBy="release_date.desc"
                popular.setTextColor(Color.GRAY)
                latest.setTextColor(Color.WHITE)
                view_popular.visibility = View.INVISIBLE
                view_latest.visibility = View.VISIBLE
                callingApi(sortBy)
            }

        }
    }
}
