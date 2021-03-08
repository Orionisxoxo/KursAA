package com.example.kursaa.features.characters.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.kursaa.core.base.BaseViewModel
import com.example.kursaa.core.exception.ErrorMapper
import com.example.kursaa.features.characters.domain.GetCharactersUseCase
import com.example.kursaa.features.characters.domain.model.Character
import com.example.kursaa.features.characters.presentation.model.CharacterDisplayable

class CharacterViewModel(
    private val getCharactersUseCase: GetCharactersUseCase,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {

    private val _characters by lazy {
        MutableLiveData<List<Character>>()
            .also { getCharacters(it) }
    }

    val characters: LiveData<List<CharacterDisplayable>> by lazy {
        _characters.map { characters ->
        characters.map { CharacterDisplayable(it) }
        }
    }

    private fun getCharacters(characterLiveData: MutableLiveData<List<Character>>) {
        setPendingState()
        getCharactersUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { characterLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }
    }
}