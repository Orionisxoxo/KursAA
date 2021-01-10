package com.example.kursaa.core.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kursaa.core.data.dao.KursAADao

abstract class KursAARoomDatabase : RoomDatabase() {

    abstract val kursAADao: KursAADao

    companion object {
        private const val DATABASE_NAME = "kursAADatabase"

        fun create(applicationContext: Context): KursAARoomDatabase = Room.databaseBuilder(
            applicationContext,
            KursAARoomDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
}