package com.personatech.android_assignment.ui.wallpaper

import androidx.lifecycle.ViewModel
import com.personatech.android_assignment.model.Wallpaper
import com.personatech.android_assignment.repository.WallpaperRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WallpaperViewModel : ViewModel() {
    val _wallpapers: MutableStateFlow<List<Wallpaper>> = MutableStateFlow(emptyList())
    val wallpapers: StateFlow<List<Wallpaper>> = _wallpapers.asStateFlow()

    val repository = WallpaperRepository()

    init {
        getWallpapers()
    }

    fun getWallpapers() {
        GlobalScope.launch {
            val wallpapers = repository.getWallpapers()
            _wallpapers.value = wallpapers
        }
    }
}
