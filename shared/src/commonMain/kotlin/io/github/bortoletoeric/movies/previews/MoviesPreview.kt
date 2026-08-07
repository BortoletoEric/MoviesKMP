package io.github.bortoletoeric.movies.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.github.bortoletoeric.movies.domain.model.movie1
import io.github.bortoletoeric.movies.ui.components.MoviePoster
import io.github.bortoletoeric.movies.ui.movies.MovieListScreen

@Preview(showBackground = true)
@Composable
private fun MoviePosterPreview() {
    MoviePoster(
        movie = movie1
    )
}

@Preview(showBackground = true)
@Composable
private fun MovieListScreenPreview() {
    MovieListScreen()
}