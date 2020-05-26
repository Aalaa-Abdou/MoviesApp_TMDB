package com.example.moviesapp.pojo

class MovieResponse(val results: List<Movie>)

data class Movie(val title: String, val vote_average: Double, val poster_path: String)