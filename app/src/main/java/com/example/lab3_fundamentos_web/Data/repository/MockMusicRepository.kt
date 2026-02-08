package com.example.lab3_fundamentos_web.Data.repository

import com.example.lab3_fundamentos_web.Data.Model.Song

class MockMusicRepository {

    private val songs = mutableListOf(
        Song("1", "Bohemian Rhapsody", "Queen"),
        Song("2", "Imagine", "John Lennon"),
        Song("3", "Hotel California", "Eagles"),
        Song("4", "Billie Jean", "Michael Jackson")
    )

    fun getSongs(): List<Song> = songs

    fun toggleFavorite(id: String) {
        val index = songs.indexOfFirst { it.id == id }
        if (index != -1) {
            val song = songs[index]
            songs[index] = song.copy(isFavorite = !song.isFavorite)
        }
    }
}
