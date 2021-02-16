package com.example.kursaa.features.locations.domain

import com.example.kursaa.features.locations.domain.model.Location

interface LocationRepository {
    suspend fun getLocations(): List<Location>
}