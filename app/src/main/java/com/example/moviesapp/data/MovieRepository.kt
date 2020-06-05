package com.example.moviesapp.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.moviesapp.pojo.Movie
import com.example.moviesapp.pojo.MovieResponse
import com.example.moviesapp.ui.MoviesCallBack
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MovieRepository {
    val movies: MutableLiveData<List<Movie>> = MutableLiveData()
    val apiInterface: ApiInterface = MovieClient.getRetrofit().create(ApiInterface::class.java)
    private lateinit var moviesList: List<Movie>
// in memory cache
    fun showingData(sortBy: String = "popularity.desc"){

        apiInterface.getMovies("YOUR API KEY",sortBy).enqueue(object :
            Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("this is On Failure", t.message.toString())
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    moviesList = response.body()!!.results
                    movies.postValue(moviesList)
                }else{
                    Log.e("error","can't bind data")}
            }
        })
    }
}