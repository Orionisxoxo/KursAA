package com.example.kursaa.features.characters.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kursaa.features.characters.domain.model.Character

@Entity
data class CharacterCached(
    @PrimaryKey
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val characterOriginCached: CharacterOriginCached,
    val characterLocationCached: CharacterLocationCached,
    val image: String,
    val episode: List<String>,
    val url: String
) {
    constructor(character: Character) : this(
        character.id,
        character.name,
        character.status,
        character.species,
        character.type,
        character.gender,
        CharacterOriginCached(character.origin),
        CharacterLocationCached(character.location),
        character.image,
        character.episode,
        character.url
    )

    companion object

    fun toCharacter() = Character(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        origin = characterOriginCached.toCharacterOrigin(),
        location = characterLocationCached.toCharacterLocation(),
        image = image,
        episode = episode,
        url = url
    )
}