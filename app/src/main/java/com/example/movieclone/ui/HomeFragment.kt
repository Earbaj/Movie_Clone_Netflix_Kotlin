package com.example.movieclone.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieclone.R
import com.example.movieclone.adapter.MovieAdapter
import com.example.movieclone.adapter.UpcomingMovieAdapter
import com.example.movieclone.data.Movie
import com.example.movieclone.data.MovieResponse
import com.example.movieclone.data.UpcommingMovie
import com.example.movieclone.services.RetrofitInstance
import com.example.movieclone.viewmodel.MovieViewModel
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewUpcoming: RecyclerView
    private lateinit var adapter: MovieAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter_upcoming_novie: UpcomingMovieAdapter
    private val movieViewModel: MovieViewModel by viewModels()
    private val movieList = mutableListOf<Movie>()
    private val upcomingMovieList = mutableListOf<UpcommingMovie>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize recyclerView first
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerViewUpcoming = view.findViewById(R.id.recyclerView_upcoming)
        progressBar =  view.findViewById(R.id.progressBar)
        // Set up the RecyclerView's layout manager and animator after initialization
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewUpcoming.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)


        // Set up item animator for animation
        recyclerView.itemAnimator = DefaultItemAnimator().apply {
            addDuration = 500 // Adjust duration as needed
            removeDuration = 500
        }

        // Set up adapter
        adapter = MovieAdapter(movieList)
        recyclerView.adapter = adapter

        adapter_upcoming_novie = UpcomingMovieAdapter(upcomingMovieList)
        recyclerViewUpcoming.adapter = adapter_upcoming_novie

        // Observe the ViewModel's LiveData for movie list updates
        observeMovies()

        // Fetch movies from the API
        fetchMovies()
        fetchUpcomingMovies()

        return view
    }

    private fun observeMovies() {
        progressBar.visibility = View.VISIBLE
        movieViewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            movieList.clear()
            movieList.addAll(movies)
            adapter.notifyDataSetChanged()
            // Hide ProgressBar only after upcoming movies are loaded
            if (movieList.isNotEmpty()) {
                progressBar.visibility = View.GONE
            }
        })
        movieViewModel.upcoming_movies.observe(viewLifecycleOwner, Observer { upcoming_movies ->
            upcomingMovieList.clear()
            upcomingMovieList.addAll(upcoming_movies)
            adapter_upcoming_novie.notifyDataSetChanged()
            // Hide ProgressBar only after movies are loaded
            if (upcomingMovieList.isNotEmpty()) {
                progressBar.visibility = View.GONE
            }
        })

    }

    private fun fetchMovies() {
        val apiKey = "7502b8c031c79790fe5c0b4f94fd770d" // replace with actual API key
        movieViewModel.fetchMovies(apiKey)
    }
    private fun fetchUpcomingMovies() {
        val apiKey = "7502b8c031c79790fe5c0b4f94fd770d" // replace with actual API key
        movieViewModel.fetchUpcomingMovies(apiKey)
    }
}
