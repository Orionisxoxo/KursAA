package com.example.kursaa.features.characters.di

import com.example.kursaa.features.characters.data.repository.CharacterRepositoryImpl
import com.example.kursaa.features.characters.domain.CharacterRepository
import com.example.kursaa.features.characters.domain.GetCharactersUseCase
import com.example.kursaa.features.characters.presentation.CharacterFragment
import com.example.kursaa.features.characters.presentation.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterModule = module {
    //data
    factory<CharacterRepository> { CharacterRepositoryImpl(get(), get(), get()) }

    //domain
    factory { GetCharactersUseCase(get()) }

    //presentation
    viewModel { CharacterViewModel(get()) }
    factory { CharacterFragment() }
}