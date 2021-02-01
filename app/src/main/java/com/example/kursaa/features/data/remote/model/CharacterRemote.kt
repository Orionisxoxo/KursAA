package com.example.kursaa.features.data.remote.model

import com.example.kursaa.features.character.domain.model.Character
import com.google.gson.annotations.SerializedName

data class CharacterRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin") val characterOriginRemote: CharacterOriginRemote,
    @SerializedName("location") val characterLocationRemote: CharacterLocationRemote,
    @SerializedName("image") val image: String,
    @SerializedName("episode") val episode: List<String>,
    @SerializedName("url") val url: String
) {
    fun toCharacter() = Character(
        id = this.id,
        name = this.name,
        status = this.status,
        species = this.species,
        type = this.type,
        gender = this.gender,
        origin = this.characterOriginRemote.toCharacterOrigin(),
        location = this.characterLocationRemote.toCharacterLocation(),
        image = this.image,
        episode = this.episode,
        url = this.url
    )
}

data class CharacterOriginRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toCharacterOrigin() = CharacterOriginRemote(
        name = this.name,
        url = this.url
    )
}

data class CharacterLocationRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toCharacterLocation() = CharacterLocationRemote(
        name = this.name,
        url = this.url
    )
}