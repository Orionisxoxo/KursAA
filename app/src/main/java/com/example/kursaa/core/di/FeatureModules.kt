package com.example.kursaa.core.di

import com.example.kursaa.features.characters.di.characterModule
import com.example.kursaa.features.episodes.di.episodeModule
import com.example.kursaa.features.locations.di.locationModule
import org.koin.core.module.Module

val featureModules = listOf<Module>(
    episodeModule,
    characterModule,
    locationModule
)