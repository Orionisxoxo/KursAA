package com.example.kursaa.core.di

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.dsl.module

val appModule = module {

    factory { LinearLayoutManager(get()) }

    single { GridLayoutManager(get(), 2) }

    single { DividerItemDecoration(get(), LinearLayoutManager.VERTICAL) }
}