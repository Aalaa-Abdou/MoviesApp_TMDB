package com.example.moviesapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.data.ApiInterface
import com.example.moviesapp.data.MovieClient
import com.example.moviesapp.pojo.Movie
import com.example.moviesapp.pojo.MovieResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiInterface : ApiInterface = MovieClient.getRetrofit().create(ApiInterface::class.java)

        apiInterface.getMovies("eb1523f9e5287ce93da5dcfda24bcbc7","popularity.desc").enqueue(object : Callback<MovieResponse>{
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("this is On Failure", t.message.toString())
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    populateMoviesRecycler(response.body()!!.results)
                }else{
                    Log.e("error","can't bind data")}
            }
        })


    }

    private fun populateMoviesRecycler(movieList : List<Movie>){

        recycler_view.layoutManager = GridLayoutManager(this,2)

        recycler_view.adapter = MovieAdapter(movieList)

    }
}
