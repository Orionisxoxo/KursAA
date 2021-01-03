package com.example.kursaa.core.di

import org.koin.core.module.Module

val koinInjector: List<Module> = listOf(
    networkModule
)