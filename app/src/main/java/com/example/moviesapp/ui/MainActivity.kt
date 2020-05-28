package com.example.moviesapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
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
import java.util.zip.Inflater

class MainActivity : AppCompatActivity(),View.OnClickListener {

    var sortBy: String = "popularity.desc"
    lateinit var apiInterface: ApiInterface



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        apiInterface = MovieClient.getRetrofit().create(ApiInterface::class.java)

        showingData(sortBy)

        popular.setOnClickListener(this)
        latest.setOnClickListener(this)

    }




    private fun populateMoviesRecycler(movieList : List<Movie>){

        recycler_view.layoutManager = GridLayoutManager(this,2)

        recycler_view.adapter = MovieAdapter(movieList)

    }

    private fun showingData(sortBy:String){
        apiInterface.getMovies("eb1523f9e5287ce93da5dcfda24bcbc7",sortBy).enqueue(object : Callback<MovieResponse>{
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

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.popular -> {
                sortBy="popularity.desc"
                showingData(sortBy)
            }
            R.id.latest -> {
                sortBy="release_date.desc"
                showingData(sortBy)

            }

        }
    }
}
