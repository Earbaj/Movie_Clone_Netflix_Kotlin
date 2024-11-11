package com.example.movieclone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieclone.R
import com.example.movieclone.data.PopularMovie

class PopularMovieAdapter(private val movies: List<PopularMovie>) : RecyclerView.Adapter<PopularMovieAdapter.PopularMovieViewHolder>() {

    class PopularMovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val poster: ImageView = view.findViewById(R.id.imageView)
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_popular_movie, parent, false)
        return PopularMovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: PopularMovieViewHolder, position: Int) {
        val movie = movies[position]

        holder.titleTextView.text = movie.title
        val imageUrl = "https://image.tmdb.org/t/p/w500${movie.poster_path}"
        Glide.with(holder.poster.context).load(imageUrl).into(holder.poster)
    }

    override fun getItemCount() = movies.size

    override fun onViewAttachedToWindow(holder: PopularMovieViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.alpha = 0f
        holder.itemView.animate()
            .alpha(1f)
            .setDuration(500) // Adjust duration as needed
            .start()
    }

}