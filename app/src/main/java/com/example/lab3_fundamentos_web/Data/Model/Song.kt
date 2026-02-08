package com.example.lab3_fundamentos_web.Data.Model


data class Song(
    val id: String,
    val title: String,
    val artist: String,
    val isFavorite: Boolean = false
)
