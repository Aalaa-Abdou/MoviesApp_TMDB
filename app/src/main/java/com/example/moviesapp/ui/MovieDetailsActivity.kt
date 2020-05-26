package com.example.moviesapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviesapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        movie_title.text = intent.getStringExtra("MOVIE_TITLE")
        val movieImage = intent.getStringExtra("MOVIE_IMAGE")
        Picasso.get().load(movieImage).into(movie_image)


    }
}
