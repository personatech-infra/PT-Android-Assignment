package com.personatech.android_assignment.network

import com.personatech.android_assignment.model.Wallpaper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface WallpaperApi {
    @GET("list")
    suspend fun getWallpapers(): List<Wallpaper>

    companion object {
        fun getInstance(): WallpaperApi = getRetrofitInstance().create(WallpaperApi::class.java)
    }
}

private fun getRetrofitInstance(): Retrofit {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://picsum.photos/v2/")

    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    retrofit.client(okHttpClient)
    retrofit.addConverterFactory(MoshiConverterFactory.create())

    return retrofit.build()
}
