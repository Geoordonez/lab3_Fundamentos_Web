package com.example.lab3_fundamentos_web.Data.Model


import androidx.compose.runtime.Immutable

@Immutable
data class Song(
    val id: String,
    val title: String,
    val artist: String,
    val isFavorite: Boolean = false
)
