package com.personatech.android_assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.personatech.android_assignment.ui.wallpaper.WallpaperScreen
import com.personatech.android_assignment.ui.theme.PT_AssignmentTheme
import com.personatech.android_assignment.ui.wallpaper.WallpaperViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: WallpaperViewModel = ViewModelProvider(this)[WallpaperViewModel::class.java]

        setContent {
            PT_AssignmentTheme {
                WallpaperScreen(viewModel)
            }
        }
    }
}
