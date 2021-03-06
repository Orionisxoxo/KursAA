package com.example.kursaa.features.episodes.domain

import com.example.kursaa.core.base.UseCase
import com.example.kursaa.features.episodes.domain.model.Episode

class GetEpisodesUseCase(private val episodeRepository: EpisodeRepository) :
    UseCase<List<Episode>, Unit>() {

    override suspend fun action(params: Unit) = episodeRepository.getEpisodes()
}