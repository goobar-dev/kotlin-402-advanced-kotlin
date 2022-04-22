import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import kotlinx.datetime.*

@Composable
@Preview
fun AppScreen(windowState: WindowState) {

    val state: MonthState by remember { mutableStateOf(MonthStateGenerator.getState()) }

    MaterialTheme {

        Column(modifier = Modifier.padding(32.dp)) {
            Text(text = state.name, style = MaterialTheme.typography.h1)
            when {
                windowState.size.width > 400.dp -> LargeAppScreen(state)
                else -> SmallAppScreen(state)
            }
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun LargeAppScreen(state: MonthState) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(100.dp),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(state.length) {
            Card(
                modifier = Modifier.defaultMinSize(minWidth = 100.dp, minHeight = 150.dp)
            ) {
                Text((it + 1).toString())
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun SmallAppScreen(state: MonthState) {
    LazyColumn(
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(state.length) {
            Card(
                modifier = Modifier.defaultMinSize(minHeight = 150.dp).fillMaxWidth(1f)
            ) {
                Text((it + 1).toString())
            }
        }
    }
}