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

        val poster: ImageView = view.findViewById(R.id.imageView)
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]

        holder.titleTextView.text = movie.title
        val imageUrl = "https://image.tmdb.org/t/p/w500${movie.poster_path}"
        Glide.with(holder.poster.context).load(imageUrl).into(holder.poster)
    }

    override fun getItemCount() = movies.size

    override fun onViewAttachedToWindow(holder: MovieViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.alpha = 0f
        holder.itemView.animate()
            .alpha(1f)
            .setDuration(500) // Adjust duration as needed
            .start()
    }

}
