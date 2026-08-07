package io.github.bortoletoeric.movies.ui.movies

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.bortoletoeric.movies.domain.model.movie1
import io.github.bortoletoeric.movies.ui.components.MoviesSection

@Composable
fun MovieListRoute() {
    MovieListScreen()
}

@Composable
fun MovieListScreen() {
    Scaffold { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            item {
                MoviesSection(
                    title = "Popular Movies",
                    movies = List(10) {
                        movie1
                    }
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