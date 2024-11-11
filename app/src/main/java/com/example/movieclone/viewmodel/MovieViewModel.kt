package com.example.movieclone.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieclone.data.Movie
import com.example.movieclone.data.PopularMovie
import com.example.movieclone.data.UpcommingMovie
import com.example.movieclone.repository.MovieRepository

class MovieViewModel : ViewModel() {
    private val repository = MovieRepository()
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies

    private val _upcoming_movies = MutableLiveData<List<UpcommingMovie>>()
    val upcoming_movies: LiveData<List<UpcommingMovie>> get() = _upcoming_movies

    private val _popular_movies = MutableLiveData<List<PopularMovie>>()
    val popular_movies: LiveData<List<PopularMovie>> get() = _popular_movies

    fun fetchMovies(apiKey: String) {
        repository.getPopularMovies(apiKey).observeForever { movieList ->
            _movies.value = movieList
        }
    }
    fun fetchUpcomingMovies(apiKey: String) {
        repository.getUpcomingMovies(apiKey).observeForever { upcomingMovieList ->
            _upcoming_movies.value = upcomingMovieList
        }
    }
    fun fetchPopularMovies(apiKey: String) {
        repository.getPopularMoviesNew(apiKey).observeForever { popularMovieList ->
            _popular_movies.value = popularMovieList
        }
    }
}
