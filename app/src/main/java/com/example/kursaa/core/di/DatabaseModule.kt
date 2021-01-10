package com.example.kursaa.core.di

import com.example.kursaa.core.data.dao.KursAADao
import com.example.kursaa.core.data.database.KursAARoomDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideKursAADao(database: KursAARoomDatabase): KursAADao {
        return database.kursAADao
    }

    single { KursAARoomDatabase.create(androidApplication()) }

    single { provideKursAADao(get()) }
}