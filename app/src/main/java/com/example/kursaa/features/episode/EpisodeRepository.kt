package com.example.kursaa.features.episode

import com.example.kursaa.features.episode.domain.model.Episode

interface EpisodeRepository {
    suspend fun getEpisodes(): List<Episode>
}