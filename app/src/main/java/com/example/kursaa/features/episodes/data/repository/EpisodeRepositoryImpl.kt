package com.example.kursaa.features.episodes.data.repository

import com.example.kursaa.core.api.RickAndMortyApi
import com.example.kursaa.core.exception.ErrorWrapper
import com.example.kursaa.core.exception.callOrThrow
import com.example.kursaa.core.network.NetworkStateProvider
import com.example.kursaa.features.episodes.data.local.EpisodeDao
import com.example.kursaa.features.episodes.data.local.model.EpisodeCached
import com.example.kursaa.features.episodes.domain.EpisodeRepository
import com.example.kursaa.features.episodes.domain.model.Episode

class EpisodeRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val episodeDao: EpisodeDao,
    private val networkStateProvider: NetworkStateProvider,
    private val errorWrapper: ErrorWrapper
) : EpisodeRepository {

    override suspend fun getEpisodes(): List<Episode> {
        return if (networkStateProvider.isNetworkAvailable()) {
            callOrThrow(errorWrapper) { getEpisodesFromRemote() }
                .also { saveEpisodesToLocal(it) }
        } else {
            getEpisodesFromLocal()
        }
    }

    private suspend fun getEpisodesFromRemote(): List<Episode> {
//        throw HttpException(Response.error<List<Episode>>(500, ResponseBody.Companion.create(null, "")))
        return rickAndMortyApi.getEpisodes()
            .results.map { it.toEpisode() }
    }

    private suspend fun saveEpisodesToLocal(episodes: List<Episode>) {
        episodes.map { EpisodeCached(it) }
            .toTypedArray()
            .let { episodeDao.saveEpisodes(*it) }
    }

    private suspend fun getEpisodesFromLocal(): List<Episode> {
        return episodeDao.getEpisodes()
            .map { it.toEpisode() }
    }
}