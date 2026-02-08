package com.example.lab3_fundamentos_web.ui.viewmodel

import com.example.lab3_fundamentos_web.Data.Model.Song

sealed class HomeUiState {
    object Loading : HomeUiState()
    data class Success(val songs: List<Song>) : HomeUiState()
}
