package com.example.lab3_fundamentos_web.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.lab3_fundamentos_web.Data.Model.Song

@Composable
fun SongCard(
    song: Song,
    onFavoriteClick: (String) -> Unit
) {
    Card {
        ListItem(
            headlineContent = { Text(song.title) },
            supportingContent = { Text(song.artist) },
            trailingContent = {
                IconButton(onClick = { onFavoriteClick(song.id) }) {
                    Icon(
                        imageVector = if (song.isFavorite)
                            Icons.Filled.Favorite
                        else
                            Icons.Outlined.FavoriteBorder,
                        contentDescription = null
                    )
                }
            }
        )
    }
}


