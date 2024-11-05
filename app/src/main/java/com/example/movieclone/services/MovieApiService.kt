package com.example.movieclone.services

import com.example.movieclone.data.MovieResponse
import com.example.movieclone.data.UpcomingMoviesResponse
import com.example.movieclone.data.UpcommingMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("movie/now_playing")
    fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int = 1
    ): Call<MovieResponse>

    @GET("movie/upcoming")
    fun getUpcomingMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int = 1
    ): Call<UpcomingMoviesResponse>

}
