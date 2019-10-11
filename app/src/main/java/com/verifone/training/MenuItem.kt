package com.verifone.training

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MenuItem(
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String = "",
    @SerializedName("price") val price: Double = 0.0,
    @SerializedName("thumbnail") val thumbnail: String? = null,
    @SerializedName("fullDescription") val fullDescription: String = "",
    @SerializedName("phot") val photo: String? = null
): Parcelable