package com.personatech.android_assignment.repository

import com.personatech.android_assignment.model.Wallpaper
import com.personatech.android_assignment.network.WallpaperApi

class WallpaperRepository() {
    val api: WallpaperApi = WallpaperApi.getInstance()

    suspend fun getWallpapers(): List<Wallpaper> {
        return api.getWallpapers()
    }
}
