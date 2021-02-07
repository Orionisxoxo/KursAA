package com.example.kursaa.features.characters.domain

import com.example.kursaa.core.base.UseCase
import com.example.kursaa.features.characters.domain.model.Character

class GetCharactersUseCase(private val characterRepository: CharacterRepository) :
    UseCase<List<Character>, Unit>() {

    override suspend fun action(params: Unit) = characterRepository.getCharacters()
}