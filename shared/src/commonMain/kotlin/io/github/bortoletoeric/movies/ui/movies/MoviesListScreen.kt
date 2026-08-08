package io.github.bortoletoeric.movies.ui.movies

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.bortoletoeric.movies.data.network.IMAGE_SMALL_BASE_URL
import io.github.bortoletoeric.movies.data.network.KtorClient
import io.github.bortoletoeric.movies.domain.model.Movie
import io.github.bortoletoeric.movies.domain.model.movie1
import io.github.bortoletoeric.movies.ui.components.MoviesSection

@Composable
fun MovieListRoute() {
    var popularMovies by remember {
        mutableStateOf(emptyList<Movie>())
    }

    LaunchedEffect(Unit) {
        val response = KtorClient.getMovies("popular")
        popularMovies = response.results.map { moviesResponse ->
            Movie(
                id = moviesResponse.id,
                title = moviesResponse.title,
                overview = moviesResponse.overview,
                posterUrl = "$IMAGE_SMALL_BASE_URL${moviesResponse.posterPath}"
            )
        }
    }

    MovieListScreen(
        popularMovies = popularMovies,
    )
}

@Composable
fun MovieListScreen(
    popularMovies: List<Movie>,
) {
    Scaffold { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            item {
                MoviesSection(
                    title = "Popular Movies",
                    movies = popularMovies,
                )
            }

            item {
                MoviesSection(
                    title = "Top Hated Movies",
                    movies = List(10) {
                        movie1
                    },
                    modifier = Modifier
                        .padding(top = 32.dp)
                )
            }

            item {
                MoviesSection(
                    title = "Upcoming Movies",
                    movies = List(10) {
                        movie1
                    },
                    modifier = Modifier
                    .padding(top = 32.dp)
                )
            }
        }
    }
}