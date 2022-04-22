package dev.goobar.kmmsample

import kotlinx.coroutines.newFixedThreadPoolContext

object PokemonAppDispatchers {
  val network = newFixedThreadPoolContext(3, "PokemonAppNetworkThreadPool")
}