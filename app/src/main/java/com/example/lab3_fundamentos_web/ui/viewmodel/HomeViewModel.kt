package com.example.lab3_fundamentos_web.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lab3_fundamentos_web.repository.MockMusicRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(
    private val repository: MockMusicRepository = MockMusicRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadSongs()
    }

    private fun loadSongs() {
        _uiState.value = HomeUiState.Success(repository.getSongs())
    }

    fun onFavoriteClick(songId: String) {
        repository.toggleFavorite(songId)
        loadSongs()
    }
}
