package com.example.moviesapp.data

import com.example.moviesapp.pojo.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("discover/movie?api_key=eb1523f9e5287ce93da5dcfda24bcbc7&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1")
    fun getMovies(
        @Query("api_key") api_key: String,
        @Query("sort_by") sort_by:String
    ): Call<MovieResponse>
}