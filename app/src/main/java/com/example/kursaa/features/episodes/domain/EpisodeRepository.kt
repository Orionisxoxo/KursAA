package com.example.kursaa.features.episodes.domain

import com.example.kursaa.features.episodes.domain.model.Episode

interface EpisodeRepository {
    suspend fun getEpisodes(): List<Episode>
}