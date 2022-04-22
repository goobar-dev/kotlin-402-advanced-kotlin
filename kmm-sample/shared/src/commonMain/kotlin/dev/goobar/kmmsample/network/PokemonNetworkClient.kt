package dev.goobar.kmmsample.network

import dev.goobar.kmmsample.data.Pokemon
import dev.goobar.kmmsample.data.PokemonRequestResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class PokemonNetworkClient {

  private val client = HttpClient() {
    install(ContentNegotiation) {
      json(Json { ignoreUnknownKeys = true })
    }
  }

  suspend fun fetchPokemon(count: Int): List<Pokemon> {
    val response: PokemonRequestResponse = client.get("https://pokeapi.co/api/v2/pokemon/?limit=$count").body()
    return response.results.also { client.close() }
  }
}