package io.github.bortoletoeric.movies.data.network

import io.github.bortoletoeric.movies.data.network.model.MoviesListResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.get
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private const val BASE_URL = "https://api.themoviedb.org"
const val IMAGE_SMALL_BASE_URL = "https://image.tmdb.org/t/p/w154"

object KtorClient {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }

        install(Auth) {
            bearer {
                loadTokens {
                    BearerTokens(
                        accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxMzFhYmY2NjZlMWUxMzY1YWFiMGNmYjJkMmQwZmE1OCIsIm5iZiI6MTc4NjEzMzgwMC41Nzc5OTk4LCJzdWIiOiI2YTc2M2QyODQ2Y2E4NmQ5NzZlMTBlYjQiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.3ipjovErU_BkMZ7DSmavBs_E_oASYiKo_ZFWWCmAL68",
                        refreshToken = "YOUR_REFRESH_TOKEN"
                    )
                }
            }
        }

        install(Logging) {
            logger = Logger.SIMPLE
            level = LogLevel.ALL
            sanitizeHeader { header -> header == HttpHeaders.Authorization }
        }
    }

    suspend fun getMovies(category: String, language: String = "pt-br"): MoviesListResponse {
        return client.get("$BASE_URL/3/movie/$category") {
            url {
                parameters.append("language", language)
            }
        }.body()
    }
}