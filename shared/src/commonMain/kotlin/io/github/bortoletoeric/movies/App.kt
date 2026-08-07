package io.github.bortoletoeric.movies

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.bortoletoeric.movies.navigation.AppRoutes
import io.github.bortoletoeric.movies.ui.movies.MovieListRoute

@Composable
@Preview
fun App() {
    MaterialTheme {
        var navController = rememberNavController()
        NavHost(navController, startDestination = AppRoutes.MoviesList) {
            composable<AppRoutes.MoviesList> {
                MovieListRoute()
            }

            composable<AppRoutes.MovieDetails> {
                // MovieDetailsScreen()
            }
        }
    }
}