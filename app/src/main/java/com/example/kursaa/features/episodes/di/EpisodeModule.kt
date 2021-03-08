package com.example.kursaa.features.episodes.di

import com.example.kursaa.features.episodes.data.repository.EpisodeRepositoryImpl
import com.example.kursaa.features.episodes.domain.EpisodeRepository
import com.example.kursaa.features.episodes.domain.GetEpisodesUseCase
import com.example.kursaa.features.episodes.presentation.EpisodeFragment
import com.example.kursaa.features.episodes.presentation.EpisodeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val episodeModule = module {
    //data
    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get()) }

    //domain
    factory { GetEpisodesUseCase(get()) }

    //presentation
    viewModel { EpisodeViewModel(get()) }
    factory { EpisodeFragment() }
}