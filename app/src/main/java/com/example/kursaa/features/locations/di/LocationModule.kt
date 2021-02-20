package com.example.kursaa.features.locations.di

import com.example.kursaa.features.locations.data.repository.LocationsRepositoryImpl
import com.example.kursaa.features.locations.domain.GetLocationsUseCase
import com.example.kursaa.features.locations.domain.LocationRepository
import com.example.kursaa.features.locations.presentation.LocationFragment
import com.example.kursaa.features.locations.presentation.LocationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val locationModule = module {
    //data
    factory<LocationRepository> { LocationsRepositoryImpl(get(), get(), get()) }

    //domain
    factory { GetLocationsUseCase(get()) }

    //presentation
    viewModel { LocationViewModel(get()) }
    factory { LocationFragment() }
}