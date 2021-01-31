package com.example.kursaa.features.character

import com.example.kursaa.features.episode.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}