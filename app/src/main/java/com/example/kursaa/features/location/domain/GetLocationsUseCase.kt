package com.example.kursaa.features.location.domain

import com.example.kursaa.core.base.UseCase
import com.example.kursaa.features.location.LocationRepository
import com.example.kursaa.features.location.domain.model.Location

class GetLocationsUseCase(private val locationRepository: LocationRepository) :
    UseCase<List<Location>, Unit>() {

    override suspend fun action(params: Unit) = locationRepository.getLocations()
}