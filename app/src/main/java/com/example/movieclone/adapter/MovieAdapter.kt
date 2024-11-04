package com.example.movieclone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieclone.R
import com.example.movieclone.data.Movie

class MovieAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.movieTitle)
        val releaseDate: TextView = view.findViewById(R.id.releaseDate)
        val overview: TextView = view.findViewById(R.id.overview)
        val rating: TextView = view.findViewById(R.id.rating)
        val poster: ImageView = view.findViewById(R.id.posterImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.title.text = movie.title
        holder.releaseDate.text = "Release Date: ${movie.release_date}"
        holder.overview.text = movie.overview
        holder.rating.text = "Rating: ${movie.vote_average}"

        val imageUrl = "https://image.tmdb.org/t/p/w500${movie.poster_path}"
        Glide.with(holder.poster.context).load(imageUrl).into(holder.poster)
    }

    override fun getItemCount() = movies.size
}
