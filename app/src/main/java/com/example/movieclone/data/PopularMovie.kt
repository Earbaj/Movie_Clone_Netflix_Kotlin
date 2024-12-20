package com.example.movieclone.data

data class PopularMoviesResponse(
    val page: Long,
    val results: List<PopularMovie>,
    val totalPages: Long,
    val totalResults: Long,
)

data class PopularMovie(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Long>,
    val id: Long,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Long,
)
