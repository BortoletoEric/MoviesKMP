package io.github.bortoletoeric.movies.data.network.repository

import io.github.bortoletoeric.movies.data.network.KtorClient
import io.github.bortoletoeric.movies.data.network.model.MoviesListResponse
import io.github.bortoletoeric.movies.domain.model.MovieSection
import io.github.bortoletoeric.movies.domain.model.toModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class MoviesRepository(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.Default,
) {

    suspend fun getMovieSections(): List<MovieSection> {
        return withContext(ioDispatcher) {
            val popularMoviesDeferred = async { KtorClient.getMovies("popular") }
            val topRatedMoviesDeferred = async { KtorClient.getMovies("top_rated") }
            val upcomingMoviesDeferred = async { KtorClient.getMovies("upcoming") }

            val popularMovies = popularMoviesDeferred.await()
            val topRatedMovies = topRatedMoviesDeferred.await()
            val upcomingMovies = upcomingMoviesDeferred.await()

            listOf(
                MovieSection(
                    sectionType = MovieSection.SectionType.POPULAR,
                    movies = popularMovies.results.map { it.toModel() }
                ),
                MovieSection(
                    sectionType = MovieSection.SectionType.TOP_RATED,
                    movies = topRatedMovies.results.map { it.toModel() }
                ),
                MovieSection(
                    sectionType = MovieSection.SectionType.UPCOMING,
                    movies = upcomingMovies.results.map { it.toModel() }
                )
            )
        }
    }
}