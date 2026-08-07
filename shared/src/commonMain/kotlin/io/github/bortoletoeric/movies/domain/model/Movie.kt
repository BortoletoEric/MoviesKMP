package io.github.bortoletoeric.movies.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String
)

//fake objects
val movie1 = Movie(
    id = 1,
    title = "Minecraft",
    overview = "Minecraft is a game about building things",
    posterUrl = "https://example.com/poster1.jpg"
)
