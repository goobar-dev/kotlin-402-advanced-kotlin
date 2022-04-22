import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greeting()
    
    @State private var pokemonList: [Pokemon] = []

    var body: some View {
            Text(greet)
            List(pokemonList, id: \.name){ pokemon in
                Text(pokemon.name)
            }
            .onAppear {
                PokemonPresenter { pokemon in
                    self.pokemonList = pokemon
                }
            }
        }
}
