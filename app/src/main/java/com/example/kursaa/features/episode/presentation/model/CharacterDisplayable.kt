package com.example.kursaa.features.episode.presentation.model

import com.example.kursaa.features.episode.domain.model.Character
import com.example.kursaa.features.episode.domain.model.CharacterLocation
import com.example.kursaa.features.episode.domain.model.CharacterOrigin

data class CharacterDisplayable(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: CharacterOriginDisplayable,
    val location: CharacterLocationDisplayable,
    val image: String,
    val episode: List<String>,
    val url: String
) {
    constructor(character: Character) : this(
        id = character.id,
        name = character.name,
        status = character.status,
        species = character.species,
        type = character.type,
        gender = character.gender,
        origin = CharacterOriginDisplayable(character.name, character.url),
        location = CharacterLocationDisplayable(character.name, character.url),
        image = character.image,
        episode = character.episode,
        url = character.url
    )
}

data class CharacterOriginDisplayable(
    val name: String,
    val url: String
) {
    constructor(characterOrigin: CharacterOrigin) : this(
        name = characterOrigin.name,
        url = characterOrigin.url
    )
}

data class CharacterLocationDisplayable(
    val name: String,
    val url: String
) {
    constructor(characterLocation: CharacterLocation) : this(
        name = characterLocation.name,
        url = characterLocation.url
    )
}