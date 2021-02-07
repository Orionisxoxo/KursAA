package com.example.kursaa.mock

import com.example.kursaa.core.api.model.*
import com.example.kursaa.features.characters.data.local.model.CharacterCached
import com.example.kursaa.features.characters.data.local.model.CharacterLocationCached
import com.example.kursaa.features.characters.data.local.model.CharacterOriginCached
import com.example.kursaa.features.episodes.data.local.model.EpisodeCached
import com.example.kursaa.features.locations.data.local.model.LocationCached
import org.jetbrains.annotations.TestOnly

@TestOnly
fun ResponseInfo.Companion.mock() = ResponseInfo(
    count = 10,
    pages = 3,
    next = "next page url",
    prev = "previous page url"
)

@TestOnly
fun EpisodeRemote.Companion.mock() = EpisodeRemote(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url",
    created = "example data"
)

@TestOnly
fun EpisodesResponse.Companion.mock() = EpisodesResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        EpisodeRemote.mock(),
        EpisodeRemote.mock(),
        EpisodeRemote.mock()
    )
)

@TestOnly
fun EpisodeCached.Companion.mock() = EpisodeCached(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)

@TestOnly
fun CharacterRemote.Companion.mock() = CharacterRemote(
    id = 1,
    name = "character name",
    status = "character status",
    species = "character species",
    type = "character type",
    gender = "character gender",
    characterOriginRemote = CharacterOriginRemote.mock(),
    characterLocationRemote = CharacterLocationRemote.mock(),
    image = "character image",
    episode = emptyList(),
    url = "character url",
    created = "example data"
)

@TestOnly
fun CharacterOriginRemote.Companion.mock() = CharacterOriginRemote(
    name = "character origin name",
    url = "character origin url"
)

@TestOnly
fun CharacterLocationRemote.Companion.mock() = CharacterLocationRemote(
    name = "character location name",
    url = "character location url"
)

@TestOnly
fun CharactersResponse.Companion.mock() = CharactersResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        CharacterRemote.mock(),
        CharacterRemote.mock(),
        CharacterRemote.mock()
    )
)

@TestOnly
fun CharacterCached.Companion.mock() = CharacterCached(
    id = 1,
    name = "character name",
    status = "character status",
    species = "character species",
    type = "character type",
    gender = "character gender",
    characterOriginRemote = CharacterOriginCached.mock(),
    characterLocationRemote = CharacterLocationCached.mock(),
    image = "character image",
    episode = emptyList<String>(),
    url = "character url"
)

@TestOnly
fun CharacterOriginCached.Companion.mock() = CharacterOriginCached(
    name = "character name",
    url = "character url"
)

@TestOnly
fun CharacterLocationCached.Companion.mock() = CharacterLocationCached(
    name = "character name",
    url = "character url"
)

@TestOnly
fun LocationRemote.Companion.mock() = LocationRemote(
    id = 1,
    name = "location name",
    type = "location type",
    dimension = "location dimension",
    residents = emptyList(),
    url = "episode url",
    created = "example data"
)

@TestOnly
fun LocationsResponse.Companion.mock() = LocationsResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        LocationRemote.mock(),
        LocationRemote.mock(),
        LocationRemote.mock()
    )
)

@TestOnly
fun LocationCached.Companion.mock() = LocationCached(
    id = 1,
    name = "location name",
    type = "location type",
    dimension = "location dimension",
    residents = emptyList(),
    url = "episode url"
)