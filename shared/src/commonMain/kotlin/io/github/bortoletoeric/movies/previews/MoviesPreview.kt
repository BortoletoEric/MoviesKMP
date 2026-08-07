package io.github.bortoletoeric.movies.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.github.bortoletoeric.movies.ui.components.MoviePoster
import io.github.bortoletoeric.movies.ui.movies.MovieListScreen

@Preview(showBackground = true)
@Composable
private fun MoviePosterPreview() {
    MoviePoster()
}

@Preview(showBackground = true)
@Composable
private fun MovieListScreenPreview() {
    MovieListScreen()
}