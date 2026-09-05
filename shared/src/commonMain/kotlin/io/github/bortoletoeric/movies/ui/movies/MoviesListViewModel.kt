package io.github.bortoletoeric.movies.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.bortoletoeric.movies.data.network.repository.MoviesRepository
import io.github.bortoletoeric.movies.domain.model.MovieSection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MoviesListViewModel (
    private val moviesRepository: MoviesRepository
) : ViewModel() {

    private val _moviesListState = MutableStateFlow<MoviesListState>(MoviesListState.Loading)
    val moviesListState = _moviesListState.asStateFlow()

    init {
        getMovieSections()
    }

    private fun getMovieSections() {
        viewModelScope.launch {
            try {
                val moviesSections = moviesRepository.getMovieSections()
                _moviesListState.update {
                    MoviesListState.Success(moviesSections)
                }
            } catch (e: Exception) {
                _moviesListState.update {
                    MoviesListState.Error(e.message ?: "Unknown error")
                }
            }
        }
    }

    sealed interface MoviesListState {
        object Loading : MoviesListState
        data class Success(val movies: List<MovieSection>) : MoviesListState
        data class Error(val message: String) : MoviesListState
    }
}