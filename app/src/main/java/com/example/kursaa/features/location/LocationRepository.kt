package com.example.kursaa.features.location

import com.example.kursaa.features.location.domain.model.Location

interface LocationRepository {
    suspend fun getLocations(): List<Location>
}