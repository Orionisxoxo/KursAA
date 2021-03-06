package com.example.kursaa.features.episodes.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.example.kursaa.core.data.UiState
import com.example.kursaa.core.exception.ErrorMapper
import com.example.kursaa.features.episodes.domain.GetEpisodesUseCase
import com.example.kursaa.features.episodes.domain.model.Episode
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

internal class EpisodeViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN episode live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = EpisodeViewModel(useCase, errorMapper)

        //when
        viewModel.episodes.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() `should be` UiState.Pending
    }

    @Test
    fun `WHEN episode live data is observed THEN invoke use case to get episodes`() {
        //given
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = EpisodeViewModel(useCase, errorMapper)

        //when
        viewModel.episodes.observeForTesting()

        //then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case result is success WHEN episode live data is observed THEN set idle state AND set result in live data`() {
        //given
        val episodes = listOf(Episode.mock(), Episode.mock(), Episode.mock())
        val useCase = mockk<GetEpisodesUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Episode>>) -> Unit>()(Result.success(episodes))
            }
        }
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = EpisodeViewModel(useCase, errorMapper)

        //when
        viewModel.episodes.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() `should be` UiState.Idle
        viewModel.episodes.getOrAwaitValue().forEachIndexed() { index, episodeDisplayable ->
            val episode = episodes[index]
            episodeDisplayable.name `should be` episode.name
            episodeDisplayable.airDate `should be` episode.airDate
            episodeDisplayable.code `should be` episode.code
        }
    }

    @Test
    fun `GIVEN use case result is failure WHEN episode live data is observed THEN set idle state AND set error message in live data`() {
        //given
        val throwable = Throwable("Ops... Something went wrong")
        val useCase = mockk<GetEpisodesUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Episode>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val errorMapper = mockk<ErrorMapper> {
            every { map(any()) } returns throwable.message!!
        }
        val viewModel = EpisodeViewModel(useCase, errorMapper)

        //when
        viewModel.message.observeForever(observer)
        viewModel.episodes.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() `should be` UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}