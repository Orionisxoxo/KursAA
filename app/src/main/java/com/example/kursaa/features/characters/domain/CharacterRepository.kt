package com.example.kursaa.features.characters.domain

import com.example.kursaa.features.characters.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}