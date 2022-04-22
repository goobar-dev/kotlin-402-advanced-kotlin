package dev.goobar.kmmsample.data

import kotlinx.serialization.Serializable

@Serializable
internal data class PokemonRequestResponse(
  val count: Int,
  val results: List<Pokemon>
)