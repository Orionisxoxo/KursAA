package com.example.kursaa.features.character.domain

import com.example.kursaa.features.character.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}