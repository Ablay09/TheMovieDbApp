package com.example.themoviedbapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.themoviedbapp.popularMovies.presentation.PopularMoviesFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment()
    }

    private fun setFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.mainContainer, PopularMoviesFragment.newInstance())
            .addToBackStack(PopularMoviesFragment.NAME)
            .commit()
    }
}