package com.example.kursaa.features.character.domain.model

import com.example.kursaa.features.data.remote.model.CharacterLocationRemote
import com.example.kursaa.features.data.remote.model.CharacterOriginRemote

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: CharacterOriginRemote,
    val location: CharacterLocationRemote,
    val image: String,
    val episode: List<String>,
    val url: String
)

data class CharacterOrigin(
    val name: String,
    val url: String
)

data class CharacterLocation(
    val name: String,
    val url: String
)