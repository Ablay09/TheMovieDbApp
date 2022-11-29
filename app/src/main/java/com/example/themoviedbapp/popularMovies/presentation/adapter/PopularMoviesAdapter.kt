package com.example.themoviedbapp.popularMovies.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedbapp.databinding.ItemMovieBinding
import com.example.themoviedbapp.popularMovies.domain.model.Movie

class PopularMoviesAdapter : RecyclerView.Adapter<PopularMoviesAdapter.MovieViewHolder>() {

    private val movies: MutableList<Movie> = mutableListOf()

    fun setMovies(movies: List<Movie>) {
        this.movies.clear()
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val movieItemBinding = ItemMovieBinding.inflate(
            LayoutInflater.from(parent.context)
        )
        return MovieViewHolder(movieItemBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

    inner class MovieViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.titleTextView.text = movie.title.orEmpty()
        }
    }
//    inner class
    /*private object MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

    }*/
}