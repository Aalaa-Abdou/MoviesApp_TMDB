package com.example.moviesapp.data

import android.util.Log
import com.example.moviesapp.pojo.MovieResponse
import com.example.moviesapp.ui.MoviesCallBack
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MovieRepository {
    val apiInterface: ApiInterface = MovieClient.getRetrofit().create(ApiInterface::class.java)

    fun showingData(callBack: MoviesCallBack, sortBy: String = "popularity.desc"){
        apiInterface.getMovies("eb1523f9e5287ce93da5dcfda24bcbc7",sortBy).enqueue(object :
            Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("this is On Failure", t.message.toString())
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    callBack.onMovieLoaded(response.body()!!.results)
                }else{
                    Log.e("error","can't bind data")}
            }
        })
    }
}