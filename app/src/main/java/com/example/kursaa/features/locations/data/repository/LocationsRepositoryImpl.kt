package com.example.kursaa.features.locations.data.repository

import com.example.kursaa.core.api.RickAndMortyApi
import com.example.kursaa.core.network.NetworkStateProvider
import com.example.kursaa.features.locations.data.local.LocationDao
import com.example.kursaa.features.locations.data.local.model.LocationCached
import com.example.kursaa.features.locations.domain.LocationRepository
import com.example.kursaa.features.locations.domain.model.Location

class LocationsRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val locationDao: LocationDao,
    private val networkStateProvider: NetworkStateProvider
) : LocationRepository {

    override suspend fun getLocations(): List<Location> {
        return if (networkStateProvider.isNetworkAvailable()) {
            getLocationsFromRemote()
                .also { saveLocationsToLocal(it) }
        } else {
            getLocationsFromLocal()
        }
    }

    private suspend fun getLocationsFromRemote(): List<Location> {
        return rickAndMortyApi.getLocations()
            .results.map { it.toLocation() }
    }

    private suspend fun saveLocationsToLocal(locations: List<Location>) {
        locations.map { LocationCached(it) }
            .toTypedArray()
            .let { locationDao.saveLocations(*it) }
    }

    private suspend fun getLocationsFromLocal(): List<Location> {
        return locationDao.getLocations()
            .map { it.toLocation() }
    }
}