package dev.goobar.kmmsample.ui

import dev.goobar.kmmsample.PokemonAppDispatchers
import dev.goobar.kmmsample.data.Pokemon
import dev.goobar.kmmsample.network.PokemonNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

actual class PokemonPresenter(callback:(List<Pokemon>) -> Unit) {

  private val scope = MainScope()
  private val networkClient = PokemonNetworkClient()

  init {
    scope.launch(PokemonAppDispatchers.network) {
      val pokemon = networkClient.fetchPokemon(9)
      callback(pokemon)
    }

  }
}