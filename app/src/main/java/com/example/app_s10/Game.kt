package com.example.app_s10

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Game(
    val id: String = "",
    val title: String = "",
    val genre: String = "",
    val platform: String = "",
    val rating: Float = 0f,
    val description: String = "",
    val releaseYear: Int = 0,
    val completed: Boolean = false,
    val userId: String = "",
    val createdAt: Long = System.currentTimeMillis()

) : Parcelable