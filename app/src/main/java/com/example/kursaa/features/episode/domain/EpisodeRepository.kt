package com.example.kursaa.features.episode.domain

import com.example.kursaa.features.episode.domain.model.Episode

interface EpisodeRepository {
    suspend fun getEpisodes(): List<Episode>
}