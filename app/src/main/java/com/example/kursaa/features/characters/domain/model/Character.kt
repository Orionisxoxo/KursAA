package com.example.kursaa.features.characters.domain.model

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: CharacterOrigin,
    val location: CharacterLocation,
    val image: String,
    val episode: List<String>,
    val url: String
) {
    companion object
}

data class CharacterOrigin(
    val name: String,
    val url: String
) {
    companion object
}

data class CharacterLocation(
    val name: String,
    val url: String
) {
    companion object
}