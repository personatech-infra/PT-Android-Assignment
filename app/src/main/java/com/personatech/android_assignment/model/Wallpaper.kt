package com.personatech.android_assignment.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Wallpaper(
    val id: String,
    val author: String,
    val width: Int,
    val height: Int,
    val download_url: String
)
