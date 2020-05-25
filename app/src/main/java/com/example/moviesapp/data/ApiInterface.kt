package com.example.moviesapp.data

import com.example.moviesapp.pojo.Movie
import com.example.moviesapp.pojo.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/discover/movie")
    fun getMovies(
        @Query("api_key") api_key: String,
        @Query("sort_by") sort_by: String
    ): Call<MovieResponse>
}