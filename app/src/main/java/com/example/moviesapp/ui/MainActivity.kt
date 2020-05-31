package com.example.moviesapp.ui

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

    private var sortBy: String = "popularity.desc"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MovieRepository.showingData(object :
            MoviesCallBack {
            override fun onMovieLoaded(Movies: List<Movie>) {
                populateMoviesRecycler(Movies)
            }
        }, sortBy)





        popular.setOnClickListener(this)
        latest.setOnClickListener(this)

    }




    private fun populateMoviesRecycler(movieList : List<Movie>){

        recycler_view.layoutManager = GridLayoutManager(this,2)

        recycler_view.adapter = MovieAdapter(movieList)

    }



    override fun onClick(v: View?) {
        when(v?.id){
            R.id.popular -> {
                sortBy="popularity.desc"
            }
            R.id.latest -> {
                sortBy="release_date.desc"
            }

        }
    }
}
