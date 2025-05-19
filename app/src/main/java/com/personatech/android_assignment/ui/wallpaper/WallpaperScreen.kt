package com.personatech.android_assignment.ui.wallpaper

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.personatech.android_assignment.model.Wallpaper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WallpaperScreen(
    viewModel: WallpaperViewModel
) {
    val wallpapers by viewModel.wallpapers.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Wallpapers") }) }
    ) { innerPadding ->
        LazyVerticalGrid(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = wallpapers
            ) { wallpaper ->
                WallpaperItem(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .aspectRatio(1f),
                    wallpaper = wallpaper
                )
            }
        }
    }
}

@Composable
fun WallpaperItem(
    modifier: Modifier = Modifier,
    wallpaper: Wallpaper
) {
    Box(modifier = modifier) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = wallpaper.download_url,
            contentDescription = wallpaper.id,
            contentScale = ContentScale.Crop
        )
    }
}
