package com.example.themoviedbapp.popularMovies.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.themoviedbapp.databinding.FragmentPopularMoviesBinding
import com.example.themoviedbapp.popularMovies.presentation.adapter.PopularMoviesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class PopularMoviesFragment : Fragment() {

    private var _binding: FragmentPopularMoviesBinding? = null
    private val binding: FragmentPopularMoviesBinding
        get() = _binding!!

    private val viewModel: PopularMoviesViewModel by viewModel()
//    private val viewModel: PopularMoviesViewModel by viewModel()
    private var adapter: PopularMoviesAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPopularMoviesBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initObservers()
        viewModel.getPopularMovies()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        adapter = null
    }

    private fun initAdapter() {
        adapter = PopularMoviesAdapter()
        binding.popularMoviesRecycler.adapter = adapter
    }

    private fun initObservers() {
        viewModel.popularMoviesLiveData.observe(viewLifecycleOwner) { movies ->
            Timber.d("movies: $movies")
            adapter?.setMovies(movies)
        }
    }

    companion object {
        const val NAME = "PopularMoviesFragment"

        fun newInstance() = PopularMoviesFragment()
    }
}