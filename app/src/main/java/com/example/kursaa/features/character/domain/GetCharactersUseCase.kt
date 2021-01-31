package com.example.kursaa.features.character.domain

import com.example.kursaa.core.base.UseCase
import com.example.kursaa.features.character.CharacterRepository
import com.example.kursaa.features.episode.domain.model.Character

class GetCharactersUseCase(private val characterRepository: CharacterRepository) :
    UseCase<List<Character>, Unit>() {

    override suspend fun action(params: Unit) = characterRepository.getCharacters()
}