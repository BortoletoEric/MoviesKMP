package io.github.bortoletoeric.movies.domain.model

import io.github.bortoletoeric.movies.data.network.IMAGE_SMALL_BASE_URL
import io.github.bortoletoeric.movies.data.network.model.MoviesResponse

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String
)

fun MoviesResponse.toModel() = Movie(
    id = this.id,
    title = this.title,
    overview = this.overview,
    posterUrl = "$IMAGE_SMALL_BASE_URL${this.posterPath}"
)

//fake objects
val movie1 = Movie(
    id = 1,
    title = "Minecraft",
    overview = "Minecraft is a game about building things",
    posterUrl = "https://example.com/poster1.jpg"
)
