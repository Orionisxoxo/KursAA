package com.example.kursaa.features.locations.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.example.kursaa.core.data.UiState
import com.example.kursaa.core.exception.ErrorMapper
import com.example.kursaa.features.locations.domain.GetLocationsUseCase
import com.example.kursaa.features.locations.domain.model.Location
import com.example.kursaa.mock.mock
import com.example.kursaa.utils.ViewModelTest
import com.example.kursaa.utils.getOrAwaitValue
import com.example.kursaa.utils.observeForTesting
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.`should be`
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LocationViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN location live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetLocationsUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = LocationViewModel(useCase, errorMapper)

        //when
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() `should be` UiState.Pending
    }

    @Test
    fun `WHEN location live data is observed THEN invoke use case to get locations`() {
        //given
        val useCase = mockk<GetLocationsUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = LocationViewModel(useCase, errorMapper)

        //when
        viewModel.locations.observeForTesting()

        //then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case result is success WHEN location live data is observed THEN set idle state AND set result in live data`() {
        //given
        val locations = listOf(Location.mock(), Location.mock(), Location.mock())
        val useCase = mockk<GetLocationsUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Location>>) -> Unit>()(Result.success(locations))
            }
        }
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = LocationViewModel(useCase, errorMapper)

        //when
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() `should be` UiState.Idle
        viewModel.locations.getOrAwaitValue().forEachIndexed() { index, locationDisplayable ->
            val location = locations[index]
            locationDisplayable.name `should be` location.name
            locationDisplayable.type `should be` location.type
            locationDisplayable.dimension `should be` location.dimension
            locationDisplayable.residents `should be` location.residents
        }
    }

    @Test
    fun `GIVEN use case result is failure WHEN location live data is observed THEN set idle state AND set error message in live data`() {
        //given
        val throwable = Throwable("Ops... Something went wrong")
        val useCase = mockk<GetLocationsUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Location>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val errorMapper = mockk<ErrorMapper> {
            every { map(any()) } returns throwable.message!!
        }
        val viewModel = LocationViewModel(useCase, errorMapper)

        //when
        viewModel.message.observeForever(observer)
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() `should be` UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}