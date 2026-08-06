package io.github.bortoletoeric.movies

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform