package com.example.kursaa.core.api

import com.example.kursaa.core.api.model.CharactersResponse
import com.example.kursaa.core.api.model.EpisodesResponse
import com.example.kursaa.core.api.model.LocationsResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("episodes")
    suspend fun getEpisodes(): EpisodesResponse

    @GET("character")
    suspend fun getCharacters(): CharactersResponse

    @GET("location")
    suspend fun getLocations(): LocationsResponse
}