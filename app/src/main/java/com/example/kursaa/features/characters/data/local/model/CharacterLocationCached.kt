package com.example.kursaa.features.characters.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kursaa.features.characters.domain.model.CharacterLocation

@Entity
data class CharacterLocationCached(
    @PrimaryKey
    val name: String,
    val url: String
) {
    constructor(characterLocation: CharacterLocation) : this(
        characterLocation.name,
        characterLocation.url
    )

    companion object

    fun toCharacterLocation() = CharacterLocation(
        name = name,
        url = url
    )
}