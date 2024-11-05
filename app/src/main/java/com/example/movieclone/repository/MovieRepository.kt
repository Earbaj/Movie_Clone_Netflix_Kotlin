package com.example.movieclone.repository

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.MutableLiveData
import com.example.movieclone.data.Movie
import com.example.movieclone.data.MovieResponse
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
}
