package com.example.moviesapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.moviesapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.recycler_item.*

class MovieDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        movie_title.text = intent.getStringExtra("MOVIE_TITLE")
        val movieImage = intent.getStringExtra("MOVIE_IMAGE")
        Picasso.get().load(movieImage).into(movie_image)
        movie_rate_tv.text = intent.getStringExtra("MOVIE_RATE")
        movie_overview_tv.text = intent.getStringExtra("MOVIE_OVER_VIEW")





    }
}
