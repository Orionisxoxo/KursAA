package com.example.kursaa.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.kursaa.features.characters.data.local.CharacterDao
import com.example.kursaa.features.episodes.data.local.EpisodeDao
import com.example.kursaa.features.episodes.data.local.model.EpisodeCached
import com.example.kursaa.features.locations.data.local.LocationDao

@Database(entities = [EpisodeCached::class], version = 1)
@TypeConverters(ListConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun episodeDao(): EpisodeDao

//    abstract fun characterDao(): CharacterDao
//
//    abstract fun locationDao(): LocationDao
}