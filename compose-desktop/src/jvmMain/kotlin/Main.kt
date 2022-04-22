import androidx.compose.ui.window.*

fun main() = application {
    val state = rememberWindowState(placement = WindowPlacement.Floating)

    Window(
        onCloseRequest = ::exitApplication,
        state = state,
        title = "Compose Desktop Calendar"
    ) {
        AppScreen(state)
    }
}
