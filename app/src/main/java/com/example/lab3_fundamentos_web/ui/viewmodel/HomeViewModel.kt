package com.example.lab3_fundamentos_web.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lab3_fundamentos_web.Data.repository.MockMusicRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {

    private val repository = MockMusicRepository()

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        loadSongs()
    }

    private fun loadSongs() {
        _uiState.value = HomeUiState.Success(repository.getSongs())
    }

    fun onFavoriteClick(id: String) {
        repository.toggleFavorite(id)
        loadSongs()
    }
}
