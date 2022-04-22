package dev.goobar.kmmsample.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import dev.goobar.kmmsample.Greeting
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.goobar.kmmsample.data.Pokemon
import dev.goobar.kmmsample.ui.PokemonPresenter

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : ComponentActivity() {

    private val presenter = PokemonPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val state by presenter.state.collectAsState()

            MaterialTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                   PokemonList(pokemon = state)
                }
            }
        }
    }
}

@Composable
private fun PokemonList(pokemon: List<Pokemon>) {
    LazyColumn(
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(pokemon) { pokemon ->
            Card() {
                Column(modifier = Modifier.padding(20.dp).fillMaxWidth(1f)) {
                    Text(pokemon.name)
                }
            }
        }
    }
}
