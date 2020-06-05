package com.example.moviesapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.data.MovieRepository
import com.example.moviesapp.pojo.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MovieDetailsActivity : AppCompatActivity(){

    private lateinit var moviesList: List<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        println("CLICKED")
         var currentPosition = intent.getIntExtra("currentPosition",0)
        MovieRepository.movies.observe(this, Observer {
            positionCallback(it)
        })
        MovieRepository.showingData("popularity.desc")
    }

    fun positionCallback(moviesList: List<Movie>) {
        recycler_view.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recycler_view.adapter = MovieDetailsAdapter(moviesList)
    }
}

