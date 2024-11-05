package com.example.movieclone.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieclone.data.Movie
import com.example.movieclone.repository.MovieRepository

class MovieViewModel : ViewModel() {
    private val repository = MovieRepository()
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies

    fun fetchMovies(apiKey: String) {
        repository.getPopularMovies(apiKey).observeForever { movieList ->
            _movies.value = movieList
        }
    }
}
