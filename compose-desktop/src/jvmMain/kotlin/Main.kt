// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun App(windowState: WindowState) {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {

        if (windowState.size.width > 400.dp) {
            LazyVerticalGrid(
                cells = GridCells.Adaptive(100.dp)
            ) {
                items(40) {
                    Card(
                        modifier = Modifier.defaultMinSize(minWidth = 100.dp, minHeight = 150.dp)
                    ) {
                        Text(it.toString())
                    }
                }
            }
        } else {
            LazyColumn(

            ) {
                items(40) {
                    Card(
                        modifier = Modifier.defaultMinSize(minHeight = 150.dp).fillMaxWidth(1f)
                    ) {
                        Text(it.toString())
                    }
                }
            }
        }

    }
}

fun main() = application {
    val state = rememberWindowState(placement = WindowPlacement.Floating)

    Window(onCloseRequest = ::exitApplication, state = state) {
        App(state)
    }
}
