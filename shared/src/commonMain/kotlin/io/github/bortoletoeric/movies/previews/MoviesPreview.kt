package io.github.bortoletoeric.movies.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.github.bortoletoeric.movies.domain.model.MovieSection
import io.github.bortoletoeric.movies.domain.model.movie1
import io.github.bortoletoeric.movies.ui.components.MoviePoster
import io.github.bortoletoeric.movies.ui.movies.MovieListScreen
import io.github.bortoletoeric.movies.ui.movies.MoviesListViewModel

@Preview(showBackground = true)
@Composable
private fun MovieListScreenPreviewSucess() {
    MovieListScreen(
        moviesListState = MoviesListViewModel.MoviesListState.Success(
            movies = listOf(
                MovieSection(
                    sectionType = MovieSection.SectionType.POPULAR,
                    movies = listOf(
                        movie1,
                    )
                )
            )
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun MoviePosterPreview() {
    MoviePoster(
        movie = movie1
    )
}

@Preview(showBackground = true)
@Composable
private fun MovieListScreenPreviewError() {
    MovieListScreen(
        moviesListState = MoviesListViewModel.MoviesListState.Error("Error")
    )
}

@Preview(showBackground = true)
@Composable
private fun MovieListScreenPreviewLoading() {
    MovieListScreen(
        moviesListState = MoviesListViewModel.MoviesListState.Loading
    )
}