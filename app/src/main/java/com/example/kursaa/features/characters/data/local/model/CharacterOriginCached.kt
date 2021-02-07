package com.example.kursaa.features.characters.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kursaa.features.characters.domain.model.CharacterOrigin

@Entity
data class CharacterOriginCached(
    @PrimaryKey
    val name: String,
    val url: String
) {
    constructor(characterOrigin: CharacterOrigin) : this(
        characterOrigin.name,
        characterOrigin.url
    )

    companion object

    fun toCharacterOrigin() = CharacterOrigin(
        name = name,
        url = url
    )
}