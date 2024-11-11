package com.example.movieclone.repository

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.MutableLiveData
import com.example.movieclone.data.Movie
import com.example.movieclone.data.MovieResponse
import com.example.movieclone.data.PopularMovie
import com.example.movieclone.data.PopularMoviesResponse
import com.example.movieclone.data.UpcomingMoviesResponse
import com.example.movieclone.data.UpcommingMovie
import com.example.movieclone.services.RetrofitInstance

class MovieRepository {
    private val apiService = RetrofitInstance.api

    fun getPopularMovies(apiKey: String): MutableLiveData<List<Movie>> {
        val moviesData = MutableLiveData<List<Movie>>()

        apiService.getPopularMovies(apiKey).enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    moviesData.value = response.body()!!.results
                } else {
                    moviesData.value = emptyList()
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                // Handle failure, could set to empty list or handle errors appropriately
                moviesData.value = emptyList()
            }
        })

        return moviesData
    }

    fun getUpcomingMovies(apiKey: String): MutableLiveData<List<UpcommingMovie>> {
        val moviesData = MutableLiveData<List<UpcommingMovie>>()

        apiService.getUpcomingMovies(apiKey).enqueue(object : Callback<UpcomingMoviesResponse> {
            override fun onResponse(call: Call<UpcomingMoviesResponse>, response: Response<UpcomingMoviesResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    moviesData.value = response.body()!!.results
                } else {
                    moviesData.value = emptyList()
                }
            }

            override fun onFailure(call: Call<UpcomingMoviesResponse>, t: Throwable) {
                // Handle failure, could set to empty list or handle errors appropriately
                moviesData.value = emptyList()
            }
        })

        return moviesData
    }


    fun getPopularMoviesNew(apiKey: String): MutableLiveData<List<PopularMovie>> {
        val moviesData = MutableLiveData<List<PopularMovie>>()

        apiService.getPopularMoviesNew(apiKey).enqueue(object : Callback<PopularMoviesResponse> {
            override fun onResponse(call: Call<PopularMoviesResponse>, response: Response<PopularMoviesResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    moviesData.value = response.body()!!.results
                } else {
                    moviesData.value = emptyList()
                }
            }

            override fun onFailure(call: Call<PopularMoviesResponse>, t: Throwable) {
                // Handle failure, could set to empty list or handle errors appropriately
                moviesData.value = emptyList()
            }
        })

        return moviesData
    }


}
