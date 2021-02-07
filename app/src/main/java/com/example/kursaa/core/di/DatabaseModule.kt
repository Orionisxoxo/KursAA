package com.example.kursaa.core.di

import com.example.kursaa.core.data.dao.KursAADao
import com.example.kursaa.core.data.database.KursAARoomDatabase
import com.example.kursaa.core.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideKursAADao(database: KursAARoomDatabase): KursAADao {
        return database.kursAADao
    }

    single { get<AppDatabase>().episodeDao() }

//    single { get<AppDatabase>().characterDao() }
//
//    single { get<AppDatabase>().locationDao() }

    single { KursAARoomDatabase.create(androidApplication()) }

    single { provideKursAADao(get()) }
}