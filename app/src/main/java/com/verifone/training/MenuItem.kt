package com.verifone.training

import androidx.annotation.DrawableRes

data class MenuItem(
    val title: String,
    val description: String = "",
    val price: Double = 0.0,
    val thumbnail: DrawableRes? = null,
    val fullDescription: String = "",
    val photo: DrawableRes? = null
)