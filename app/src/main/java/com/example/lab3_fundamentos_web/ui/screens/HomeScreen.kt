package com.example.lab3_fundamentos_web.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.material3.*
import com.example.lab3_fundamentos_web.ui.components.SongCard
import com.example.lab3_fundamentos_web.ui.viewmodel.HomeUiState
import com.example.lab3_fundamentos_web.ui.viewmodel.HomeViewModel

@Composable
fun HomeScreen() {

    val viewModel = remember { HomeViewModel() }
    val state by viewModel.uiState.collectAsState()

    when (state) {
        is HomeUiState.Loading -> {
            CircularProgressIndicator()
        }

        is HomeUiState.Success -> {
            val songs = (state as HomeUiState.Success).songs
            LazyColumn {
                items(songs) { song ->
                    SongCard(
                        song = song,
                        onFavoriteClick = viewModel::onFavoriteClick
                    )
                }
            }
        }
    }
}
