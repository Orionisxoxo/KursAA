package com.example.kursaa.features.episodes.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.Test

internal class GetEpisodesUseCaseTest {

    @Test
    fun `when use case is invoked then execute getEpisodes method from repository`() {
        //given
        val repository = mockk<EpisodeRepository>(relaxed = true)
        val useCase = GetEpisodesUseCase(repository)

        //when
        useCase(
            params = Unit,
            scope = GlobalScope
        )

        //then
        coVerify { repository.getEpisodes() }
    }
}