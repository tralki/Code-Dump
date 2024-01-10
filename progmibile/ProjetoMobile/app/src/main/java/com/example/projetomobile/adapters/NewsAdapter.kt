package com.example.projetomobile.adapters

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.example.projetomobile.R
import com.example.projetomobile.models.NewsItem
import com.bumptech.glide.request.target.Target

class NewsAdapter(private val onItemClick: (Int) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val newsList = mutableListOf<NewsItem>()

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]

        // Bind data to views
        holder.titleTextView.text = news.title
        holder.dateTextView.text = news.date
        // Load image using Glide
        Glide.with(holder.itemView)
            .load(news.image_url)
            .centerCrop()
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_image)
                .error(R.drawable.error_image))
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.d("Glide", "Failed to load image: ${e?.message}")
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    //apos carregamento bem sucedido
                    // caso queiramos adicionar um background
                    // holder.imageView.setBackgroundResource(R.color.colorPrimary)
                    return false
                }
            })
            .into(holder.imageView)

        // Set click listener to handle item click
        holder.cardView.setOnClickListener { onItemClick(position) }

        // Toggle visibility of the description based on the expanded state
        holder.descriptionTextView.text = news.description
        holder.descriptionTextView.visibility = if (news.isExpanded) View.VISIBLE else View.GONE
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun updateNewsList(newList: List<NewsItem>) {
        newsList.clear()
        newsList.addAll(newList)
        notifyDataSetChanged()
    }

    fun toggleExpansion(position: Int) {
        val news = newsList[position]
        news.isExpanded = !news.isExpanded
        notifyItemChanged(position)
    }
}