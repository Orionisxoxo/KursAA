package com.example.kursaa.core.data

sealed class UiState {
    object Idle : UiState()
    object Pending : UiState()
}