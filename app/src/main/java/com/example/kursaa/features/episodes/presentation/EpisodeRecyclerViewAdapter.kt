package com.example.kursaa.features.episodes.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kursaa.R
import com.example.kursaa.features.episodes.presentation.model.EpisodeDisplayable

class EpisodeRecyclerViewAdapter : RecyclerView.Adapter<EpisodeRecyclerViewAdapter.EpisodeViewHolder>() {

    private val episodes by lazy { mutableListOf<EpisodeDisplayable>() }

    fun setEpisodes(episodes: List<EpisodeDisplayable>) {
        if (episodes.isNotEmpty()) {
            this.episodes.clear()
        }

        this.episodes.addAll(episodes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): EpisodeViewHolder {
        val itemView = LayoutInflater
            .from(viewGroup.context)
            .inflate(R.layout.episode_item, viewGroup, false)

        return EpisodeViewHolder(itemView)
    }

    override fun onBindViewHolder(episodeViewHolder: EpisodeViewHolder, position: Int) {
        episodeViewHolder.nameText.text = episodes[position].toString()
        episodeViewHolder.airDateText.text = episodes[position].toString()
    }

    override fun getItemCount() = episodes.size

    class EpisodeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var nameText: TextView = view.findViewById(R.id.name) as TextView
        var airDateText: TextView = view.findViewById(R.id.airDate) as TextView
    }
}