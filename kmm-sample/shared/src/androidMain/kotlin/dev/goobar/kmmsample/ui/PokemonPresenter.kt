package dev.goobar.kmmsample.ui

import dev.goobar.kmmsample.PokemonAppDispatchers
import dev.goobar.kmmsample.data.Pokemon
import dev.goobar.kmmsample.network.PokemonNetworkClient
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

actual class PokemonPresenter {
  private val scope = MainScope()
  private val networkClient = PokemonNetworkClient()

  private val _state: MutableStateFlow<List<Pokemon>> = MutableStateFlow(listOf())
  val state = _state.asStateFlow()

  init {
    scope.launch(PokemonAppDispatchers.network) {
      _state.emit(networkClient.fetchPokemon(9))
    }
  }
}