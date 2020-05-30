package com.example.moviesapp.ui

import com.example.moviesapp.pojo.Movie

interface MoviesCallBack {
    fun onMovieLoaded(Movies: List<Movie>)
}