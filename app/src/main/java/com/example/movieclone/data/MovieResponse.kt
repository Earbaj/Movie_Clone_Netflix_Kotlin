package com.example.movieclone.data

data class MovieResponse(
    val results: List<Movie>
)

data class Movie(
    val id: Int,
    val title: String,
    val release_date: String,
    val overview: String,
    val vote_average: Double,
    val poster_path: String
)
